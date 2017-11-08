import java.util.ArrayList;


public  class Cache {
	// arraylist cache
	public static ArrayList<URLObject> pages = new ArrayList<URLObject>();

	
	
	public static synchronized void ADD(String url,String html)
	// adds to pages
	{
		
		URLObject uo =  new URLObject();
		uo.url = url;
		uo.html = html;
		pages.add(uo);	
	
	}
	
	
	
	public static String cacheCheck(String No_Cache,String URL)
	{
		if (No_Cache.contains("false"))
		{
			
			String response = Cache.search(URL);
			if (response.equals(null))
			{
				
				String html = Url.getHTML(URL);
				Cache.ADD(URL , html);
				response = html;
				
				
			}
			System.out.println("if false :" + response);
			return response;
			
			
		}else//(No_Cache == "true")
		{
			
			//URLObject.printpages();
			String html = Url.getHTML(URL);
			Cache.ADD(URL , html);
			//System.out.println("if true" );
		
			return html;
		}	
		
	}
	
	
	

	public static String search(String url)
	{
		String response = "Not in cache";
		for (int i=0; i<pages.size(); i++)
		{
			URLObject u = (URLObject)pages.get(i);
			if(u.url.equals(url))
			{
			
				response = u.html;
				break;
				
			}
			
		}
		return response;
	}
	
}
