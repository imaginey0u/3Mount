package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.*;

public class oneDay {
	
	public void executeGet() throws UnsupportedEncodingException, URISyntaxException{
	HttpGet get = null;
	
	String url = "http://is.shijiebang.com/trip/dateinterval/?param=[{\"superid\":1255,\"poi\":[14873],\"visapoi\":[6896],\"defaultport\":14873}]";
	//String urlEncode = URLEncoder.encode(url, "utf-8");
	
	//List<NameValuePair> params = new ArrayList<NameValuePair>();
	//params.add(new BasicNameValuePair("param", "[{\"superid\":1255,\"poi\":[14873],\"visapoi\":[6896],\"defaultport\":14873}]"));
	//params.add(new BasicNameValuePair("param","%5b%7b%22superid%22%3a1255%2c%22poi%22%3a%5b14873%5d%2c%22visapoi%22%3a%5b6896%5d%2c%22defaultport%22%3a14873%7d%5d"));
	
	//String queryString = URLEncodedUtils.format(params,"utf-8");
	
	URI uri = new URI("http","is.shijiebang.com","/trip/dateinterval/","param=[{\"superid\":1255,\"poi\":[14873],\"visapoi\":[6896],\"defaultport\":14873}]",null);
	
	System.out.println(uri);
	
	
	CloseableHttpClient httpClient = null;
	try{	
		get = new HttpGet(uri);
		httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = httpClient.execute(get);
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
	}catch(ClientProtocolException e){
		e.printStackTrace();
	}catch(IOException e1){
		e1.printStackTrace();
	}finally{
		try{
			if(get != null){
				get.releaseConnection();
			}
			if(httpClient != null){
				httpClient.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	}
	
	public static void main(String args[]) throws UnsupportedEncodingException, URISyntaxException{
		oneDay one = new oneDay();
		System.out.println("hello");
		one.executeGet();
	}
	 
}
