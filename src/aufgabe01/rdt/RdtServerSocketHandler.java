package aufgabe01.rdt;

import java.io.IOException; 
import java.io.Serializable;

import de.uulm.communication.socket.RdtSocket;
import de.uulm.communication.socket.SocketPacket;

import aufgabe01.ReceiveData;
import aufgabe01.ServerSocketHandler;

public final class RdtServerSocketHandler implements ServerSocketHandler {
	
	static {
		// bring up communication library //
		NetworkInitialiser.initServer();
	}
	
	private RdtSocket s;
	
	public RdtServerSocketHandler(int serverPort) throws IOException {
		s = RdtSocket.getRDT20Socket();
		s.bind(NetworkInitialiser.getServerAddress(serverPort));
	}

	@Override
	public ReceiveData receive() throws IOException {
		SocketPacket sp = new SocketPacket();
		s.receive(sp);
		return new RdtReceiveData(sp);
	}
	
	@Override
	public void reply(Serializable result, ReceiveData data) throws IOException, IllegalArgumentException {
		if(!(data instanceof RdtReceiveData))
			throw new IllegalArgumentException();
		SocketPacket sp = new SocketPacket();
		sp.setBody(result);
		sp.setReceiver(((RdtReceiveData) data).getSender());
		s.send(sp);
	}
}
