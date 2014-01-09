# -*- coding:utf8 -*-
import urllib,urllib2

if __name__ == '__main__':
    uri_post_base = "http://api.ltp-cloud.com/analysis/"
    api_key = ''
    text = ""
    format = ''
    pattern = ''
    req = urllib2.Request(uri_post_base)
    data    = {'api_key': api_key, 'text': text, 'format': format, 'pattern': pattern}
    params  = urllib.urlencode(data)
    result  = urllib2.urlopen(req, params)
    content = result.read().strip()
    print content
