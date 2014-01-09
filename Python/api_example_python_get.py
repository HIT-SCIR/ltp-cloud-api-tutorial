# -*- coding:utf8 -*-
import urllib2,urllib

if __name__ == '__main__':
    
    uri_get_base = "http://api.ltp-cloud.com/analysis/?"
    api_key = "";
    text = ""
    # if your text contain special characters like linefeed and '&' ,please urlencode it firstly
    text = urllib.quote(text)
    format = ""
    pattern = ""
    result = urllib2.urlopen("%sapi_key=%s&text=%s&format=%s&pattern=%s" % (uri_get_base,api_key,text,format,pattern))
    content = result.read().strip()
    print content
