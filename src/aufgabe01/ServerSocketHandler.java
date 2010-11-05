package aufgabe01;

import java.io.IOException;
import java.io.Serializable;

public interface ServerSocketHandler {

	ReceiveData receive() throws IOException;

	void reply(Serializable result, ReceiveData data) throws IOException;

}
