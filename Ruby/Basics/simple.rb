# encoding: UTF-8

require 'net/http'
require 'uri'

base_uri = 'http://api.ltp-cloud.com/analysis/?'
api_key  = 'YourApiKey'
text     = URI::encode('这是一个测试的例子。')
pattern  = 'all'
format   = 'conll'

uri = (base_uri +
       'api_key=' + api_key + '&' +
       'text='    + text    + '&' +
       'pattern=' + pattern + '&' +
       'format='  + format);

url = URI.parse(uri)
req = Net::HTTP::Get.new(url)
res = Net::HTTP.start(url.host, url.port) {|http|
    http.request(req)
}

puts res.body
