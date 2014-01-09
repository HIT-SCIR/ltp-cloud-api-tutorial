import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Api_example_java_get {
    public static void main(String[] args) throws IOException
    {
        String api_key = "";
        String pattern = "";
        String format = "";
        String url_base = "http://api.ltp-cloud.com/analysis/?";
        String text = "";
        text = URLEncoder.encode(text, "utf-8");
        
        URL url = new URL(url_base+"api_key="+api_key+"&text="+text+"&pattern="+pattern+"&format="+format);
        URLConnection connection = url.openConnection();
        connection.connect();
        BufferedReader innet = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
        String line;
        while ((line = innet.readLine())!= null)
        {
            System.out.println(line);
        }
        innet.close(); 
    }
}