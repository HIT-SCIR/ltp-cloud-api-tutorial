#-*- coding: utf-8 -*-
#!/usr/bin/env python

# This example shows how to use LTP API to perform POS taggings on the custom
# word segmentation result.

from LTML import LTML
import sys
import urllib, urllib2

def ParsingWithCustomPostags():
    ltml = LTML()
    ltml.build_from_words([("这",       "r"),
                           ("是",       "v"),
                           ("自定义",   "a"),
                           ("分词",     "n"),
                           ("结果",     "n"),
                           ("的",       "u"),
                           ("示例",     "n")])
    xml  = ltml.tostring()

    uri_base = "http://api.ltp-cloud.com/analysis/?"

    data = {
            "api_key"   : "YourApiKey",
            "text"      : xml,
            "format"    : "conll",
            "pattern"   : "dp",
            "xml_input" : "true"
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
    ParsingWithCustomPostags()
