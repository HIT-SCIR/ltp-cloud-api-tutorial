/*
 * This example shows how to use Java to build http connection and request
 * the ltp-cloud service for perform full-stack Chinese language analysis
 * and get results in specified formats
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class CommandLineAPI {
    public static void main(String[] args) {
        CommandLineAPI api = new CommandLineAPI();
        if (!api.parseArguments(args)) {
            api.usage();
            return;
        }

        try {
            api.analyze();
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        };
    }

    public void analyze() throws IOException {
        System.out.println("text: " + text);
        text = URLEncoder.encode(text, "utf-8");

        URL url = new URL("http://tapi.ltp-cloud.com/analysis/?"
                          + "api_key=" + apikey  + "&"
                          + "text="    + text    + "&"
                          + "format="  + format  + "&"
                          + "pattern=" + pattern);
        URLConnection conn = url.openConnection();
        conn.connect();

        BufferedReader innet = new BufferedReader(new InputStreamReader(
                                conn.getInputStream(),
                                "utf-8"));
        String line;
        while ((line = innet.readLine())!= null) {
            System.out.println(line);
        }
        innet.close();
    }

    private void usage() {
        System.out.println("Usage: CommandLineAPI [options]");
        System.out.println("");
        System.out.println("      --apikey  APIKEY      use to specify the api key");
        System.out.println("      --text    TEXT        use to specify the text");
        System.out.println("      --pattern PATTERN     use to specify the pattern [ws/pos/dp/ner/srl]");
        System.out.println("      --format  FORMAT      use to specify the output format [xml/json/conll]");
    }

    private boolean parseArguments(String[] args) {
        int flag = 0;
        for (int i = 0; i < args.length; ++ i) {
            if (args[i].equals("--text")) {
                ++ i; flag |= (1<<0);
                text = args[i];
            }
            else if (args[i].equals("--apikey")) {
                ++ i; flag |= (1<<1);
                apikey = args[i];
            }
            else if (args[i].equals("--pattern")) {
                ++ i; flag |= (1<<2);
                pattern = args[i];
                if (!contains(PATTERNS.class, pattern)) {
                    return false;
                }
            }
            else if (args[i].equals("--format")) {
                ++ i; flag |= (1<<3);
                format = args[i];
                if (!contains(FORMATS.class, format)) {
                    return false;
                }
            }
        }
        return flag == ((1<<4) - 1);
    }

    public static boolean contains(Class<? extends Enum> choices, String val) {
        Object[] arr = choices.getEnumConstants();
        for (Object e : arr) {
            if (((Enum) e).name().equals(val)) {
                return true;
            }
        }
        return false;
    }

    private static enum PATTERNS { ws, pos, dp, ner, srl, all; }
    private static enum FORMATS { xml, json, conll, plain; }

    private String apikey;
    private String text;
    private String pattern;
    private String format;
}
