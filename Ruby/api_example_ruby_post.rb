# encoding: UTF-8
require 'net/https'

params = {}
params["api_key"] = ""
params["text"] = ""
params["pattern"] = ""
params["format"] = ""

url = URI.parse("http://api.ltp-cloud.com/api/analysis/")
result = Net::HTTP.post_form(url,params)
puts result.body