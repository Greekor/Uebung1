package aufgabe01.rdt;

import de.uulm.communication.socket.SocketAddress;
import de.uulm.communication.socket.SocketPacket;

import aufgabe01.ReceiveData;

final class RdtReceiveData extends ReceiveData {
	
	private SocketAddress sender;
	
	RdtReceiveData(SocketPacket sp) {
		super(sp.getData());
		this.sender = sp.getSender();
	}

	SocketAddress getSender() {
		return this.sender;
	}
}
