
/*
Invoke LTP-Cloud API from JavaScript
 */

var foo = function(data){
    json_str = JSON.stringify(data);
    document.getElementsByTagName("body")[0].innerHTML += json_str;
};
window.onload=function(){
    var base = "http://api.ltp-cloud.com/analysis/?";
    var api_key = "";
    var text = "";
    var pattern = "";
    var format = "json";
    var callback = "foo";
    var uri = base + "api_key="+api_key+"&text="+text+"&pattern="+pattern+"&format="+format+"&callback="+callback;
    var script = document.createElement('script');
    script.setAttribute('src', uri);
    document.getElementsByTagName('head')[0].appendChild(script);
}