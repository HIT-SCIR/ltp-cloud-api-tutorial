# -*- coding: utf-8 -*-
#!/usr/bin/env python

# This example shows how to use Python to access the LTP API to perform full
# stack Chinese text analysis including word segmentation, POS tagging, dep-
# endency parsing, name entity recognization and semantic role labeling and
# get the result in xml format.

import urllib2, urllib

if __name__ == '__main__':
    uri_base = "http://api.ltp-cloud.com/analysis/?"
    api_key  = "YourApiKey"
    text     = "我爱北京天安门"
    # Note that if your text contain special characters such as linefeed or '&',
    # you need to use urlencode to encode your data
    text     = urllib.quote(text)
    format   = "xml"
    pattern  = "all"

    url      = (uri_base 
               + "api_key=" + api_key + "&"
               + "text="    + text    + "&"
               + "format="  + format  + "&"
               + "pattern=" + "all")

    response = urllib2.urlopen(url)
    content  = response.read().strip()
    print content
