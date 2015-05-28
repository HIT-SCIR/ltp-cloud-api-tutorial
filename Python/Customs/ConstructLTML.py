#-*- coding: utf-8 -*-
#!/usr/bin/env python

# This example shows how to construct an LTML class, which is used to transfer
# custom data for LTP to analyse.

from LTML import LTML

def CustomSegmentation():
    ltml = LTML()
    ltml.build_from_words(["天安门", "上", "太阳升"])
    print ltml.tostring()

def CustomPOSTags():
    ltml = LTML()
    ltml.build_from_words([("天安门", "N"),
                           ("上", "P"),
                           ("太阳升", "V")])
    print ltml.prettify()

if __name__=="__main__":
    CustomSegmentation()
    CustomPOSTags()
