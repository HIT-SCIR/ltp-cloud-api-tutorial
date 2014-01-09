using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net;
using System.IO;

namespace api_example_cs_get
{
    class Program
    {
        static void Main(string[] args)
        {
            String urlbase = "http://api.ltp-cloud.com/analysis/?";
            String strParam = String.Empty;
            String api_key = "";
            String text = "";
            String pattern = "";
            String format = "";
            strParam = "api_key=" + api_key + "&text=" + text + "&pattern=" + pattern + "&format=" + format;
            Encoding encoding = Encoding.GetEncoding("utf-8");
            HttpWebRequest req = WebRequest.Create(urlbase+strParam) as HttpWebRequest;
            req.Method = "GET";
            HttpWebResponse webResponse = req.GetResponse() as HttpWebResponse;
            StreamReader streamReader = new StreamReader(webResponse.GetResponseStream(), encoding);
            String result = streamReader.ReadToEnd();
            streamReader.Close();
            webResponse.Close();
            Console.Write(result);
        }
    }
}