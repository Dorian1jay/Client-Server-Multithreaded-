import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class Url {
	
	public String url_request = "https://www.dit.ie";

	public static String getHTML( String URL)
	{
		String tmp_html ="";
		try
		{
			URL u = new URL(URL);
			BufferedReader in = new BufferedReader( new InputStreamReader(u.openStream()));
			
			String inputLine;
			while((inputLine = in.readLine()) != null)
				//System.out.println(inputLine);
				tmp_html = tmp_html + inputLine;
			in.close();
		}catch(Exception e)
		{
			System.out.println("get html page error");
		}
		return tmp_html;
	}
	
	

}
