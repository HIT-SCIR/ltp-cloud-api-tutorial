using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net;
using System.IO;

namespace Simple
{
    class Program
    {
        static void Main(string[] args)
        {
            string urlbase  = "http://api.ltp-cloud.com/analysis/?";
            string api_key  = "YourApiKey";
            string text     = "我爱北京天安门";
            string pattern  = "srl";
            string format   = "conll";
            string strParam = ("api_key=" + api_key + 
                               "&text=" + text + 
                               "&pattern=" + pattern + 
                               "&format=" + format);
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