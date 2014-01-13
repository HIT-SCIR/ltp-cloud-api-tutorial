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
    public static void main(String[] args) throws IOException {
        CommandLineAPI api = new CommandLineAPI();
        if (api.parseArguments(args)) {
            return;
        }
    }

    private boolean parseArguments(String[] args) {
        for (int i = 0; i < args.length; ++ i) {
            if (args[i].equals("--text")) {
                ++ i;
                text = args[i];
            }
            else if (args[i].equals("--pattern")) {
                ++ i;
                pattern = args[i];
                if (!contains(PATTERNS.class, pattern)) {
                    return false;
                }
            }
            else if (args[i].equals("--format")) {
                ++ i;
                format = args[i];
                if (!contains(FORMATS.class, format)) {
                    return false;
                }
            }
        }
        return true;
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
