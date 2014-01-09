/*
Invoke LTP-Cloud API from Jquery

You need to download Jquery from http://jquery.com/download/ before you use it 
and reference the file in the script tag:
 */
 
 //method 1 from Jquery
 
var foo = function(data){
    json_str = JSON.stringify(data);
    alert("captured also in foo func:"+json_str);
};

$(function(){
    var base = "http://api.ltp-cloud.com/analysis/?";
    var api_key = "";
    var text = "";
    var pattern = "";
    var format = "json";
    $.ajax({
        type: "get",
        async: false,
        dataType: 'jsonp',
        //if you specify the callback function , the result can be captured in the callback function and the ajax success at the same time 
        jsonpCallback:"foo", 
        url: base + "api_key="+api_key+"&text="+text+"&pattern="+pattern+"&format="+format,
        success: function(data){
            json_str = JSON.stringify(data);
            document.getElementsByTagName("body")[0].innerHTML += json_str;
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.status + "-" + XMLHttpRequest.readyState + "-" + textStatus);
        }
    });
});

/*
//method 2 from Jquery
$(function(){
    var base = "http://api.ltp-cloud.com/analysis/?";
    var api_key = "";
    var text = "";
    var pattern = "";
    var format = "json";
    uri = base + "api_key="+api_key+"&text="+text+"&pattern="+pattern+"&format="+format+"&callback=?";
    $.getJSON(uri, function(data){
        json_str = JSON.stringify(data);
        document.getElementsByTagName("body")[0].innerHTML += json_str;
    });
});
 */