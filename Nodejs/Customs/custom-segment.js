var builder     = require('xmlbuilder');
var querystring = require('querystring');
var http        = require('http');

var doc = builder.create('xml4nlp');
var build_from_words = function(words) {
    var xml4nlp = doc
        .ele('note')
            .att('sent',    'y')
            .att('word',    'y')
            .att('pos',     'n')
            .att('parser',  'n')
            .att('ne',      'n')
            .att('srl',     'n')
            .up()
        .ele('doc')
            .ele('para')
                .att('id', '0')
                .ele('sent')
                    .att('id', '0')

    for (var i = 0; i < words.length; i ++) {
        var word = xml4nlp.ele('word');
        word.att('id', i);
        word.att('cont', words[i]);
    }

    return xml4nlp.end();
}

var data = querystring.stringify({
    'api_key'   : 'YourApiKey',
    'text'      : build_from_words(['我', '爱', '北京', '天安门', '。']),
    'xml_input' : 'true',
    'pattern'   : 'dp',
    'format'    : 'xml'
});

var request = http.request({
            host   : 'ltpapi.voicecloud.cn',
            port   : '80',
            path   : '/analysis/',
            method : 'post',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Content-Length': data.length
            }
        },
        function(res) {
            res.setEncoding('utf8');
            res.on('data', function (chunk) {
                console.log('Response: ' + chunk);
            });
        });

request.write(data);
request.end();
