package start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.*;

public class oneDay {
	
	public void executeGet(){
	HttpGet get = null;
	CloseableHttpClient httpClient = null;
	try{	
		get = new HttpGet("http://www.shijiebang.com/powers/");
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
	
	public static void main(String args[]){
		oneDay one = new oneDay();
		one.executeGet();
	}
	 
}
