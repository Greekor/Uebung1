package aufgabe01;

import java.rmi.Remote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import de.uulm.communication.naming.RemoteNamingServer;
import de.uulm.communication.naming.Server;

public class NameServer {
	/**
	 * RMI registry port
	 */
	public static final int NAMING_PORT = 33034;

	/**
	 * RMI remote object name
	 */
	public static final String NAME = "GRN " + System.getProperty("user.home");

	public static void main(String[] args) throws Throwable {

		Registry reg = LocateRegistry.createRegistry(Server.PORT);
		Remote stub = UnicastRemoteObject.exportObject(
				RemoteNamingServer.INSTANCE, NAMING_PORT);

		reg.bind(NAME, stub);
	}
}
