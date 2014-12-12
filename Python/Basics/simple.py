# -*- coding: utf-8 -*-
#!/usr/bin/env python

# This example shows how to use Python to access the LTP API to perform full
# stack Chinese text analysis including word segmentation, POS tagging, dep-
# endency parsing, name entity recognization and semantic role labeling and
# get the result in specified format.

import urllib2, urllib
import sys

if __name__ == '__main__':
    if len(sys.argv) < 2 or sys.argv[1] not in ["xml", "json", "conll"]:
        print >> sys.stderr, "usage: %s [xml/json/conll]" % sys.argv[0]
        sys.exit(1)

    uri_base = "http://ltpapi.voicecloud.cn/analysis/"
    api_key  = "YourApiKey"
    text     = "我爱北京天安门"
    # Note that if your text contain special characters such as linefeed or '&',
    # you need to use urlencode to encode your data
    text     = urllib.quote(text)
    format   = sys.argv[1]
    pattern  = "all"

    url      = (uri_base
               + "api_key=" + api_key + "&"
               + "text="    + text    + "&"
               + "format="  + format  + "&"
               + "pattern=" + "all")

    try:
        response = urllib2.urlopen(url)
        content  = response.read().strip()
        print content
    except urllib2.HTTPError, e:
        print >> sys.stderr, e.reason
