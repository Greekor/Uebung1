package aufgabe01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import aufgabe01.rdt.RdtClientSocketHandler;
import aufgabe01.tcp.TcpClientSocketHandler;

public final class EchoClient {

	// TODO: implement if required //
	
	public void loop(){
		try {
			while(true) {
				String line = read();
				this.socketHandler.send(line);
				if(line.equalsIgnoreCase("exit"))
					break;
				String answer = (String) this.socketHandler.receive();
				print(answer);
			}
			
			print("leaving loop");
		} catch(IOException e) {
			print("error in loop");
		}
	}
	
	/* please do not add or modify code below this line */
	
	private final ClientSocketHandler socketHandler;
	private final BufferedReader in;
	
	public EchoClient(ClientSocketHandler csh, BufferedReader in) throws IOException {
		socketHandler = csh;
		this.in = in;
	}
	
	private void print(String arg){
		System.out.println(arg);
	}
	
	private String read() throws IOException{
		return in.readLine();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		final ClientSocketHandler handler;
		if(args == null || args.length == 0 || !"tcp".equalsIgnoreCase(args[0])){
			handler = new RdtClientSocketHandler(1);
		} else {
			handler = new TcpClientSocketHandler();
		}
		EchoClient ec = new EchoClient(handler, new BufferedReader(new InputStreamReader(System.in)));
		ec.loop();
	}

}
