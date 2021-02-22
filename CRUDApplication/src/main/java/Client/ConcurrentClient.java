package Client;


import java.io.IOException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

/**
 * REST client can be made using Apache httpComponents or Jersey JAX-RS
 * This class shows example using apache http client.
 * For more info visit :
 * https://www.javacodegeeks.com/2012/09/simple-rest-client-in-java.html
 * https://itnext.io/how-to-create-a-simple-rest-client-for-testing-your-api-a0554d8380f8
 *
 */
public class ConcurrentClient implements  Runnable{

    private HttpGet request = new HttpGet("http://localhost:8080/posts/debit/1/5");

    @SuppressWarnings("deprecation")
    private static DefaultHttpClient getThreadSafeClient()  {
        DefaultHttpClient client = new DefaultHttpClient();
        ClientConnectionManager mgr = client.getConnectionManager();
        HttpParams params = client.getParams();
        client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);
        return client;
    }

    public static void main(String[] args) {
        ConcurrentClient r = new ConcurrentClient();
        Thread one = new Thread(r,"lucky");
        Thread two = new Thread(r,"rocky");
        one.start();
        two.start();

    }

    @Override
    public void run() {
        makeWithDrawl();
    }

    private void makeWithDrawl(){
        System.out.println(Thread.currentThread().getName() + " is going to withdraw ");
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){e.getMessage();}
        try {
           getThreadSafeClient().execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
