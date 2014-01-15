# coding: UTF-8
require 'net/http'
require 'uri'
require './LTML'

ltml = LTML.new
ltml.build_from_words(['我', '爱', '北京', '天安门'], 'UTF-8')

params = {
    :api_key    => 'YourApiKey',
    :text       => ltml.to_s,
    :format     => 'conll',
    :pattern    => 'dp',
    :xml_input  => 'true'
}

url = URI.parse("http://api.ltp-cloud.com/analysis/")

response = Net::HTTP.post_form(url, params)

puts response.body
