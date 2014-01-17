# coding: UTF-8
require 'net/http'
require 'uri'
require './LTML'

ltml = LTML.new
ltml.build_from_words_with_postags([['我', 'r'],
                                    ['爱', 'v'],
                                    ['北京', 'ns'],
                                    ['天安门', 'ns']], 'UTF-8')

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
