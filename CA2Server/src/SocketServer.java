import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	int portNumber = 44555;
	ServerSocket serversocket = null;
	Cache webCache = null;
	
	public SocketServer(Cache webCache) {
		// TODO Auto-generated constructor stub
		this.webCache = webCache;
	}

	public void runServer()
	{
		try{
			serversocket = new ServerSocket(portNumber);
			
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		while(true){
		
			
			try{
				Socket clientSocket = serversocket.accept();
				new Thread(new ScraperRunnable(clientSocket,webCache)).start();
				
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
			
		}
	}

}
