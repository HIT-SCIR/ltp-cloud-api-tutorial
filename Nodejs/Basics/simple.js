var http = require("http");

var options = {
    hostname: 'api.ltp-cloud.com',
    port: 80,
    path: ('/analysis/?'
            + 'api_key=' + 'YourApiKey' + '&'
            + 'text='    + '我爱北京天安门' + '&'
            + 'pattern=' + 'all' + '&'
            + 'format='  + 'conll'),
    method: 'GET'
};

var req = http.get(options, function(res) {
    console.log('STATUS: ' + res.statusCode);
    console.log('HEADERS: ' + JSON.stringify(res.headers));
    res.setEncoding('utf8');
    res.on('data', function (chunk) {
        console.log(chunk);
    });
});
