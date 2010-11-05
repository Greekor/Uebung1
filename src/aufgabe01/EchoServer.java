package aufgabe01;

import java.io.IOException;
import java.io.PrintStream;

import aufgabe01.rdt.RdtServerSocketHandler;
import aufgabe01.tcp.TcpServerSocketHandler;

public final class EchoServer {
	
	// TODO: implement if required //	
	
	public void loop(){
		try {
			while(true) {
				try {
					String message = this.socketHandler.receive().getString();
					if(message.equalsIgnoreCase("exit"))
						break;
					String s = invert(message);
					// TODO: Antwort senden
					this.socketHandler.reply(result, data);
				} catch(RuntimeException e) {
					
				} catch(Error e) {
					
				}
			}
			
			this.out.printf("leaving loop");
		} catch (IOException e) {
			this.out.printf("error in loop");
		}
	}
	
	/* please do not add or modify code below this line */
	
	private final ServerSocketHandler socketHandler;
	private final PrintStream out;
	
	public EchoServer(ServerSocketHandler ssh, PrintStream out) {
		socketHandler = ssh;
		this.out = out;
	}
	
	private String invert(String arg){
		StringBuffer bs = new StringBuffer();
		bs.append(arg);
		bs.reverse();
		String result = bs.toString();
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		final ServerSocketHandler handler;
		if(args == null || args.length == 0 || !"tcp".equalsIgnoreCase(args[0])){
			handler = new RdtServerSocketHandler(1);
		} else {
			handler = new TcpServerSocketHandler();
		}
		EchoServer ec = new EchoServer(handler, System.out);
		ec.loop();
	}

}
