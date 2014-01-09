# encoding: UTF-8
require "open-uri"

base_uri = "http://api.ltp-cloud.com/analysis?"
api_key = ""
text = ""
text = URI::encode(text)
pattern = ""
format = ""
uri = base_uri+"&api_key="+api_key+"&text="+text+"&pattern="+pattern+"&format="+format
result = nil
open(uri) do |http|
    result = http.read
end
puts result