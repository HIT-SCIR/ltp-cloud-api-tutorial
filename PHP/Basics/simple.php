<?php
if (isset($_POST["text"]) && isset($_POST["pattern"]) && isset($_POST["format"])) {
    $uri     = "http://ltpapi.voicecloud.cn/analysis/?";
    $apikey  = "YourApiKey";
    $text    = $_POST["text"];
    $pattern = $_POST["pattern"];
    $format  = $_POST["format"];

    $url = ($uri
            . "api_key=" . $apikey          . "&"
            . "text="    . urlencode($text) . "&"
            . "pattern=" . $pattern         . "&"
            . "format="  . $format);

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_HEADER, 0);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);

    // grab URL and pass it to the browser
    $response = curl_exec($ch);
    echo $response;
    curl_close($ch);
}
?>
