using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net;
using System.IO;
using System.Dynamic;
using System.Xml.Linq;

namespace CustomSegmentation
{
    class Program
    {
        string uriBase = "http://api.ltp-cloud.com/analysis/";
        string apiKey  = "YourApiKey";

        static void Main(string[] args)
        {
            Program program = new Program();
            program.run();
        }

        void run()
        {
            string[] words = {"我", "爱", "北京", "天安门"};
            string text = BuildFromWords(words);
            string pattern = "all";
            string format = "conll";
            string param = ("api_key=" + apiKey + 
                            "&text=" + text + 
                            "&pattern=" + pattern + 
                            "&format=" + format + 
                            "&xml_input=true");

            Encoding encoding = Encoding.GetEncoding("utf-8");
            HttpWebRequest req = WebRequest.Create(uriBase) as HttpWebRequest;
            
            try 
            {
                req.Method = "POST";
                req.ContentType = "application/x-www-form-urlencoded";

                byte[] postData = encoding.GetBytes(param);
                req.ContentLength = postData.Length;
                Stream postStream = req.GetRequestStream();
                postStream.Write(postData, 0, postData.Length);
                postStream.Close();
            
                HttpWebResponse webResponse = req.GetResponse() as HttpWebResponse;
                StreamReader streamReader = new StreamReader(webResponse.GetResponseStream(), encoding);
                String result = streamReader.ReadToEnd();
                streamReader.Close();
                webResponse.Close();
                Console.Write(result);
            }
            catch (Exception e)
            {
                Console.WriteLine("Http Request Error." + e.ToString());
            }
        }

        string BuildFromWords(string[] words) 
        {
            XElement xml = new XElement("xml4nlp", 
                new XElement("note", 
                    new XAttribute("sent", "y"),
                    new XAttribute("word", "y"),
                    new XAttribute("pos", "n"),
                    new XAttribute("parser", "n"),
                    new XAttribute("ne", "n"),
                    new XAttribute("srl", "n")
                    ),
                new XElement("doc", 
                    new XElement("para",
                        new XAttribute("id", "0"),
                        new XElement("sent",
                            new XAttribute("id", "0"),
                            from word in words select new XElement("word",
                                new XAttribute("id", Array.IndexOf(words, word)),
                                new XAttribute("cont", word)
                                )
                            )
                        )
                    )
            );

            return xml.ToString();
        }
    }
}