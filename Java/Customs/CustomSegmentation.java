/*
 * This example shows how to compose the LTP compatible mediate result represe-
 * nted in LTML. User can custom the segmentation result and invoke ltp to do
 * higher level analysis like POS Tagging.
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;

public class CustomSegmentation {
    public static void main(String argv[]) {
        CustomSegmentation api = new CustomSegmentation();
        api.analyze("file.txt");
    }

    private String buildLTMLFromWords(String[] words) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element xml4nlp = document.createElement("xml4nlp");
            document.appendChild(xml4nlp);

            Element note = document.createElement("note");
            note.setAttribute("sent",   "y");
            note.setAttribute("word",   "y");
            note.setAttribute("pos",    "n");
            note.setAttribute("ne",     "n");
            note.setAttribute("parser", "n");
            note.setAttribute("srl",    "n");
            xml4nlp.appendChild(note);

            Element doc = document.createElement("doc");
            xml4nlp.appendChild(doc);

            Element para = document.createElement("para");
            para.setAttribute("id", "0");
            doc.appendChild(para);

            Element sent = document.createElement("sent");
            sent.setAttribute("id", "0");
            para.appendChild(sent);

            for (int i = 0; i < words.length; ++ i) {
                Element word = document.createElement("word");

                StringBuilder sb = new StringBuilder();
                sb.append(i);
                word.setAttribute("id",   sb.toString());
                word.setAttribute("cont", words[i]); 

                sent.appendChild(word);
            }

            StringWriter xmlResultResource = new StringWriter();

            Transformer transformer =
                TransformerFactory.newInstance().newTransformer();

            transformer.transform(
                    new DOMSource(document),
                    new StreamResult(xmlResultResource)
                    );

            return xmlResultResource.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void analyze(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line = br.readLine();
            while (line != null) {
                String[] words = line.trim().split("[\t| ]+");
                String text = buildLTMLFromWords(words);

                if (text == null) {
                    continue;
                }

                URL url = new URL(url_base);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                String api_key = "YourApiKey";
                String pattern = "all";
                String format  = "xml";
                text = URLEncoder.encode(text, "utf-8");

                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type",
                                        "application/x-www-form-urlencoded");

                conn.connect();
                DataOutputStream out =
                    new DataOutputStream(conn.getOutputStream());

                String content = ("api_key="    + api_key   + "&"
                                  + "text="     + text      + "&"
                                  + "pattern="  + pattern   + "&"
                                  + "format="   + format    + "&"
                                  + "xml_input=true");

                out.writeBytes(content);
                out.flush();
                out.close();

                BufferedReader reader =
                    new BufferedReader(new InputStreamReader(
                                       conn.getInputStream(),
                                       "utf-8"));
                String result;

                while ((result = reader.readLine()) != null){
                    System.out.println(result);
                }
                conn.disconnect();

                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String url_base = "http://ltpapi.voicecloud.cn/analysis/";
}
