package aufgabe01.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

// TODO: keine Instanzen erzeugen lassen??
final class TcpHelper {

	static void writeDataToSocket(Socket s, Serializable result) throws IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(result);
	}
	
	static Serializable readObjectFromSocket(Socket s) throws IOException {
		try {
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			return (Serializable) ois.readObject();
		} catch(ClassNotFoundException e) {
			return null;
		}
	}
	
}
