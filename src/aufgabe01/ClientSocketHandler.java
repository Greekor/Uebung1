package aufgabe01;

import java.io.IOException;
import java.io.Serializable;

public interface ClientSocketHandler {

	void send(String tmp) throws IOException;

	Serializable receive() throws IOException;
}
