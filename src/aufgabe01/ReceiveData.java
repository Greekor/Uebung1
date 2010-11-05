package aufgabe01;

import java.io.Serializable;

public abstract class ReceiveData {

	private final Serializable ser;
	
	protected ReceiveData(Serializable s){
		ser = s;
	}
	
	public final String getString(){
		return (String) ser;
	}
}
