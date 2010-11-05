package aufgabe01.rdt;

import java.io.IOException; 
import java.io.Serializable;

import aufgabe01.ReceiveData;
import aufgabe01.ServerSocketHandler;

public final class RdtServerSocketHandler implements ServerSocketHandler {
	
	static {
		// bring up communication library //
		NetworkInitialiser.initServer();
	}
	
	// TODO: implement if required //
	
	public RdtServerSocketHandler(int serverPort) throws IOException {
		// TODO: implement //
	}

	@Override
	public ReceiveData receive() throws IOException {
		// TODO: implement //
		return null;
	}
	
	@Override
	public void reply(Serializable result, ReceiveData data) throws IOException {
		// TODO: implement //
	}
}
