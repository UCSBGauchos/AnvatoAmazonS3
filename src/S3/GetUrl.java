package S3;

import java.io.*;
import java.net.*;

public class GetUrl {
	
	private static int BUFFER_SIZE = 8096;//the size of the buffer
	
	URL url;
	HttpURLConnection conn;
	BufferedReader br;
	
	public void getHTML(String inputURL){
		try{
			url = new URL(inputURL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			url.openStream();
			
		}catch (IOException e){
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String [] args){
		GetUrl g = new GetUrl();
		g.getHTML("https://s3.amazonaws.com/AnvatoTest/people.xml");
	}
}
