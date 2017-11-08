
public class ScraperServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello server!!!!!!!");
		// cache created here so can be shared between different clients
		Cache webCache = new Cache();
		SocketServer s = new SocketServer(webCache);
		s.runServer();

	}

}
