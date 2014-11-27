#-*- coding: utf-8 -*-
#!/usr/bin/env python

# This example shows how to use LTP API to perform POS taggings on the custom
# word segmentation result.

from LTML import LTML
import sys
import urllib, urllib2

def POSTagWithCustomSegmentation():
    ltml = LTML()
    ltml.build_from_words(["自定义", "分词", "结果", "的", "示例"])
    xml  = ltml.tostring()

    uri_base = "http://ltpapi.voicecloud.cn/analysis/?"

    data = {
            "api_key"  : "YourApiKey",
            "text"     : xml,
            "format"   : "plain",
            "pattern"  : "pos",
            "xml_input": "true"
            }

    params = urllib.urlencode(data)

    try:
        request  = urllib2.Request(uri_base)
        response = urllib2.urlopen(request, params)
        content  = response.read().strip()
        print content
    except urllib2.HTTPError, e:
        print >> sys.stderr, e.reason

if __name__=="__main__":
    POSTagWithCustomSegmentation()
