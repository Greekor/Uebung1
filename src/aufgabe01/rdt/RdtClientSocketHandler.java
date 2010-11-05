package aufgabe01.rdt;

import java.io.IOException; 
import java.io.Serializable;

import de.uulm.communication.socket.RdtSocket;
import de.uulm.communication.socket.SocketPacket;

import aufgabe01.ClientSocketHandler;

public final class RdtClientSocketHandler implements ClientSocketHandler {

	static {
		// bring up communication library //
		NetworkInitialiser.initClient();
	}
	
	
	private RdtSocket s;
	private boolean lastReceived; 
	
	public RdtClientSocketHandler(int clientPort) throws IOException {
		s = RdtSocket.getRDT20Socket();
		s.bind(NetworkInitialiser.getClientAddress(clientPort));
		lastReceived = true;
	}
	
	@Override
	public void send(String tmp) throws IOException, IllegalStateException {
		if(!lastReceived)
			throw new IllegalStateException();
		SocketPacket sp = new SocketPacket();
		sp.setReceiver(NetworkInitialiser.getServerAddress());
		sp.setBody(tmp);
		s.send(sp);
	}
	
	@Override
	public Serializable receive() throws IOException, IllegalStateException {
		if(lastReceived)
			throw new IllegalStateException();
		SocketPacket sp = new SocketPacket();
		s.receive(sp);
		return sp.getData();
	}
}
