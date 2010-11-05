package aufgabe01;

import de.uulm.communication.internet.Internet;

import de.uulm.communication.internet.InternetAddress;
import de.uulm.communication.internet.InternetFactory;
import de.uulm.communication.network.Network;
import de.uulm.communication.network.PhysicalAddress;
import de.uulm.communication.network.ReliableNetwork;
import de.uulm.communication.socket.SocketAddress;
import de.uulm.communication.socket.SocketAddressFactory;

final class NetworkInitialiser {
	
	private static final String SERVER_ADDRESS = "127.0.0.1:33034";
	private static final String SERVER_NAME = "SERVER";
	
	private static final String CLIENT_ADDRESS = "127.0.0.1:33033";
	private static final String CLIENT_NAME = "CLIENT";

	static SocketAddress getClientAddress(int port){
		return SocketAddressFactory.getSocketAddress(CLIENT_NAME, port);
	}
	
	static SocketAddress getServerAddress(int port){
		return SocketAddressFactory.getSocketAddress(SERVER_NAME, port);
	}
	
	static void initServer(){
		initNetwork(SERVER_ADDRESS, SERVER_NAME);
	}
	
	static void initClient(){
		initNetwork(CLIENT_ADDRESS, CLIENT_NAME);
	}
	
	private static void initNetwork(String physical, String logical) {
		Internet<InternetAddress> internet = InternetFactory.getInternetInstance();
		PhysicalAddress physicalAddress = new PhysicalAddress(physical);
		Network network = new ReliableNetwork(physicalAddress);
		InternetAddress logicAddress = InternetAddress.toAddress(logical);
		internet.registerNetwork(logicAddress, network);
	}
	
	private NetworkInitialiser(){
		// no instances
	}
}
