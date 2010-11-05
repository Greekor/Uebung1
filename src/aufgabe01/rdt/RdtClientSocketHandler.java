package aufgabe01.rdt;

import java.io.IOException; 
import java.io.Serializable;

import aufgabe01.ClientSocketHandler;

public final class RdtClientSocketHandler implements ClientSocketHandler {

	static {
		// bring up communication library //
		NetworkInitialiser.initClient();
	}
	
	// TODO: implement if required //
	
	public RdtClientSocketHandler(int clientPort) throws IOException {
		// TODO: implement //
	}
	
	@Override
	public void send(String tmp) throws IOException {
		// TODO: implement //
	}
	
	@Override
	public Serializable receive() throws IOException {
		// TODO: implement //
		
		return null;
	}
}
