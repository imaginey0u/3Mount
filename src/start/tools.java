package start;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tools {
	
	public static void readResponse(InputStream in) throws Exception{
		 BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
		    String line = null;  
		    while ((line = reader.readLine()) != null) {  
		        System.out.println(line);  
		    }
	}

}
