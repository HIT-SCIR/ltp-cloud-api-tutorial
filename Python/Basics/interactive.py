# -*- coding: utf-8 -*-
#!/usr/bin/env python

# This example is an command line interactive example of accessing the LTP API
# by Python. It also shows how to perform specified type of analysis and ident-
# ify the output format as PLAIN.

import sys
import os
import urllib, urllib2

menu = """A Command Line Demo of LTP API
[1] Word segmentation
[2] POS Tagging
[3] Dependency Parsing
[0] Exit
"""

bye = "Bye!"

def Menu(msg):
    os.system('cls' if os.name=='nt' else 'clear')
    print >> sys.stderr, menu
    if msg != "":
        print >> sys.stderr
        print >> sys.stderr, ">>> %s" % msg

def Validate(line):
    line = line.strip()

    if line not in ["0", "1", "2", "3"]:
        return False
    return True

def Analyze(text, pattern):
    uri_base = "http://ltpapi.voicecloud.cn/analysis/?"

    data     = {
             "api_key" : "YourApiKey",
             "text"    : urllib.quote(text),
             "format"  : "plain",
             "pattern" : pattern}

    params   = urllib.urlencode(data)
    url      = uri_base + params

    try:
        response = urllib2.urlopen(url)
        content  = response.read().strip()
        return content
    except urllib2.HTTPError, e:
        return e.reason

if __name__=="__main__":
    msg = ""
    while True:
        Menu(msg)
        choice = raw_input(">>> please choose (1/2/3/0) : ")

        if not choice:
            print >> sys.stderr, bye
            break

        if not Validate(choice):
            msg = "Unknown command"
            continue

        if choice == "0":
            print >> sys.stderr, bye
            break

        text = raw_input(">>> please input your text : ")

        if choice == "1":
            print >> sys.stderr, Analyze(text, "ws")

        if choice == "2":
            print >> sys.stderr, Analyze(text, "pos")

        if choice == "3":
            print >> sys.stderr, Analyze(text, "dp")

        dummy = raw_input("input anything to continue . ")

