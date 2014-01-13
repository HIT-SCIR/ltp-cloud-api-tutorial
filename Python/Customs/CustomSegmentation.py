#-*- coding: utf-8 -*-
#!/usr/bin/env python

# This example shows how to use LTP API to perform POS taggings on the custom
# word segmentation result.

from LTML import LTML
import urllib, urllib2

def POSTagWithCustomSegmentation():
    ltml = LTML()
    ltml.build_from_words(["自定义", "分词", "结果", "的", "示例"])
    xml  = ltml.tostring()

    uri_base = "http://api.ltp-cloud.com/analysis/?"

    data = {
            "api_key" : "YourApiKey",
            "text"    : xml,
            "format"  : "plain",
            "pattern" : "postag"}

    params = urllib.urlencode(data)

    request  = urllib2.Request(uri_base)
    response = urllib2.urlopen(request, params)

    content  = response.read().strip()
    print content

if __name__=="__main__":
    POSTagWithCustomSegmentation()
