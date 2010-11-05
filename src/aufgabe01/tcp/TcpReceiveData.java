package aufgabe01.tcp;

import java.io.Serializable; 
import java.net.Socket;

import aufgabe01.ReceiveData;

final class TcpReceiveData extends ReceiveData {

	private Socket s;
	
	TcpReceiveData(Serializable ser, Socket s) {
		super(ser);
		this.s = s;
	}

	Socket getSocket() {
		return s;
	}

}
