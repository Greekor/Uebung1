package aufgabe01.tcp;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import aufgabe01.ReceiveData;
import aufgabe01.ServerSocketHandler;

public final class TcpServerSocketHandler implements ServerSocketHandler {

	final static int SERVER_PORT = 30303;
	final static SocketAddress SERVER_ADDRESS;
	
	static {
		SocketAddress tmp;
		try {
			InetAddress iaddr = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
			tmp = new InetSocketAddress(iaddr, SERVER_PORT);
		} catch (UnknownHostException uhe){
			uhe.printStackTrace();
			tmp =  null;
		}
		SERVER_ADDRESS = tmp;
	}
	
	// TODO: implement if required //
	private ServerSocket ss;	
	private Socket s;
	
	public TcpServerSocketHandler() throws IOException {
		ss = new ServerSocket();
		ss.bind(SERVER_ADDRESS);
	}
	
	@Override
	public TcpReceiveData receive() throws IOException {
		s = ss.accept();
		
		Serializable msg = TcpHelper.readObjectFromSocket(s);
		return new TcpReceiveData(msg, s);
	}

	@Override
	public void reply(Serializable result, ReceiveData data) throws IOException, IllegalArgumentException {
		if(!(data instanceof TcpReceiveData))
			throw new IllegalArgumentException();
		
		TcpHelper.writeDataToSocket(((TcpReceiveData) data).getSocket(), result);
		
		((TcpReceiveData) data).getSocket().close();
	}
}
