using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net;
using System.IO;

namespace api_example_cs_post
{
    class Program
    {
        static void Main(string[] args)
        {
            String urlbase = "http://api.ltp-cloud.com/analysis/";
            String strParam = String.Empty;
            String api_key = "";
            String text = "";
            String pattern = "";
            String format = "";
            strParam = "api_key=" + api_key + "&text=" + text + "&pattern=" + pattern + "&format=" + format;
            Encoding encoding = Encoding.GetEncoding("utf-8");
            HttpWebRequest req = WebRequest.Create(urlbase) as HttpWebRequest;
            req.Method = "POST";
            req.ContentType = "application/x-www-form-urlencoded";
            byte[] postData = encoding.GetBytes(strParam);
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
    }
}