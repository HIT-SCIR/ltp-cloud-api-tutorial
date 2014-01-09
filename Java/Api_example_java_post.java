import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Api_example_java_post {
    public static void main(String[] args) throws IOException
    {
        String api_key = "";
        String pattern = "";
        String format = "";
        String url_base = "http://api.ltp-cloud.com/analysis/";
        String text = "";
        text = URLEncoder.encode(text, "utf-8");
        
        URL url = new URL(url_base);
        HttpURLConnection  connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        String content = "api_key="+api_key+"&text="+text+"&pattern="+pattern+"&format="+format;
        out.writeBytes(content); 
        out.flush();
        out.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        connection.disconnect();
    }
}