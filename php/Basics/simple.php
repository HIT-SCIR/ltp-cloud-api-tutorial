<?php
// This example shows how to use php to access

if (isset($_POST["text"]) && isset($_POST["pattern"]) && isset($_POST["format"])) {
    $uri     = "http://api.ltp-cloud.com/analysis/?";
    $apikey  = "YourApiKey";
    $text    = $_POST["text"];
    $pattern = $_POST["pattern"];
    $format  = $_POST["format"];

    $url = ($uri
            . "api_key=" . $apikey  . "&"
            . "text="    . $text    . "&"
            . "pattern=" . $pattern . "&"
            . "format="  . $format);

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_HEADER, 0);

    // grab URL and pass it to the browser
    $data = curl_exec($ch);
    curl_close($ch);

    echo $data;
}
?>
