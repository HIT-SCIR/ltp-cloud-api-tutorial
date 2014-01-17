<?php
require_once('LTML.php');

header('Content-Type: text/html; charset=UTF-8');

if (!isset($_POST['nr_words'])) {
    exit(1);
}

// extract and compose the word list.
$nr_words = intval($_POST['nr_words']);

$words = array();

for ($i = 0; $i < $nr_words; ++ $i) {
    if (!isset($_POST['word_' . strval($i)])) {
        continue;
    }

    $word = $_POST['word_' . strval($i)];

    if (!isset($_POST['pos_' . strval($i)])) {
        continue;
    }

    $pos = $_POST['pos_' . strval($i)];

    array_push($words, array($word, $pos));
}

$xml = LTML::build_from_words_with_postags($words);

$fields = array(
    'api_key' => 'YourApiKey',
    'text'    => $xml->asXML(),
    'pattern' => 'dp',
    'format'  => 'conll',
    'xml_input' => 'true',
);

echo $fields['text'];

$url = 'http://api.ltp-cloud.com/analysis/?';

$fields_string = '';

foreach ($fields as $key => $value) {
    $fields_string .= $key . '=' . $value . '&';
}

rtrim($fields_string, '&');

//open connection
$ch = curl_init();

//set the url, number of POST vars, POST data
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_POST, count($fields));
curl_setopt($ch, CURLOPT_POSTFIELDS, $fields_string);

//execute post
$response = curl_exec($ch);
curl_close($ch);

echo $response;
?>
