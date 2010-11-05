package aufgabe01.tcp;

import java.io.IOException; 
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

import aufgabe01.ClientSocketHandler;

public final class TcpClientSocketHandler implements ClientSocketHandler {

	private boolean lastReceived = true;
	private Socket s;
	
	@Override
	public Serializable receive() throws IOException, IllegalStateException {
		// TODO: implement //
		if(lastReceived) throw new IllegalStateException();
		lastReceived = true;

		Serializable sl = TcpHelper.readObjectFromSocket(s);
		
		s.close();
		
		return sl;
	}

	@Override
	public void send(String tmp) throws IOException, IllegalStateException {
		// TODO: implement //
		if(!lastReceived) throw new IllegalStateException();
		lastReceived = false;
		
		InetAddress iaddr = InetAddress.getByName("SERVER");
		s = new Socket(iaddr, 30303);
		
		TcpHelper.writeDataToSocket(s, tmp);
		
	}
}
