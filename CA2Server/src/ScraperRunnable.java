import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ScraperRunnable implements Runnable{
	
	protected Socket clientSocket = null;
	public Cache webCache = null;
	
	//
	
	public ScraperRunnable(Socket clientSocket,Cache webCache)
	{
		this.clientSocket = clientSocket;
		this.webCache = webCache;
		
	}
	
	public void run()
	{
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter out  = new PrintWriter(clientSocket.getOutputStream(),true);
			
			//get user input 
			if(in.readLine().equals("initCalculation"))
			{
				String arg1,arg2;
				arg1 = in.readLine();
				arg2 = in.readLine();
				
								
				String URL = arg1;
				String No_Cache = arg2;
				//String html = Url.getHTML(URL);
				
				
				
				
				String Response = Cache.cacheCheck(No_Cache, URL);
				out.print(Response);
				
				
				
						
				
			}
			
			clientSocket.close();
			
		}catch(Exception e){}
	}

}
