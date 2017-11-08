import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ScraperClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String hostname = "127.0.0.1";
		int portNumber = 44555;
		Socket clientSocket;

		PrintWriter out;
		BufferedReader in;
		InputStreamReader ir;
		BufferedReader stdIn;
		
		try{
			clientSocket = new Socket(hostname,portNumber);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			ir = new InputStreamReader(clientSocket.getInputStream());
			in = new BufferedReader(ir);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			//logic
			
			out.println("initCalculation");
			
				
			
			System.out.println("Please enter URL");
			out.println(stdIn.readLine());
			
			
			System.out.println("cache (true or false)");
			out.println(stdIn.readLine());
			
			
			
			clientSocket.close();
			
		}catch(UnknownHostException e){
			System.exit(1);
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.exit(1);
			System.out.println(e.getMessage());
		}

	}

}