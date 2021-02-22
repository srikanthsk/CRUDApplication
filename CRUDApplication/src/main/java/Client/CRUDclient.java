package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * REST client can be made using Apache httpComponents or Jersey JAX-RS
 * This class shows example using apache http client.
 * For more info visit :
 * https://www.javacodegeeks.com/2012/09/simple-rest-client-in-java.html
 * https://itnext.io/how-to-create-a-simple-rest-client-for-testing-your-api-a0554d8380f8
 *
 */
public class CRUDclient {
    public static void main(String[] args) throws  IOException {
        HttpClient client = new DefaultHttpClient();
        //view all
        HttpGet request = new HttpGet("http://localhost:8080/posts");
        //view a specific post
//        HttpGet request = new HttpGet("http://localhost:8080/post/view/1");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }
    //Future Note: when u run this client if not getting response try in debug mode
}