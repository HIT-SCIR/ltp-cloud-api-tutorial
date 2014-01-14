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
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

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
    }

    public void analyze(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line = br.readLine();
            while (line != null) {
                String[] words = line.trim().split("[\t| ]+");
                String text = buildLTMLFromWords(words);
                line = br.readLine();

                String api_key = "YourApiKey";
                String pattern = "all";
                String format  = "xml";
                text = URLEncoder.encode(text, "utf-8");

                URL url = new URL("http://api.ltp-cloud.com/analysis/?"
                        + "api_key=" + api_key + "&"
                        + "text=" + text + "&"
                        + "format=" + format + "&"
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
