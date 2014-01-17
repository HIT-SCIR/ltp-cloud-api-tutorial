<?php
class LTML
{
    public static function build_from_words($words) 
    {
        $xml4nlp = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><xml4nlp />');
        $note = $xml4nlp->addChild( 'note', '' );
        $note->addAttribute( 'sent', 'y' );
        $note->addAttribute( 'word', 'y' );
        $note->addAttribute( 'pos', 'n' );
        $note->addAttribute( 'parser', 'n' );
        $note->addAttribute( 'ne', 'n' );
        $note->addAttribute( 'srl', 'n' );
        $doc = $xml4nlp->addChild( 'doc' );
        $para = $doc->addChild( 'para' );
        $para->addAttribute( 'id', '0' );
        $sent = $para->addChild( 'sent' );
        $sent->addAttribute( 'id', '0' );

        for ($i = 0; $i < count($words); $i ++) {
            $word = $sent->addChild( 'word', '' );
            $word->addAttribute( 'id', strval($i) );
            $word->addAttribute( 'cont', $words[$i] );
        }

        return $xml4nlp;
    }

    public static function build_from_words_with_postags($words_with_postags)
    {
        $xml4nlp = new SimpleXMLElement('<?xml version="1.0" encoding="UTF-8"?><xml4nlp />');
        $note = $xml4nlp->addChild('note', '');
        $note->addAttribute( 'sent', 'y' );
        $note->addAttribute( 'word', 'y' );
        $note->addAttribute( 'pos', 'y' );
        $note->addAttribute( 'parser', 'n' );
        $note->addAttribute( 'ne', 'n' );
        $note->addAttribute( 'srl', 'n' );

        $doc = $xml4nlp->addChild( 'doc' );
        $para = $doc->addChild( 'para' );
        $para->addAttribute( 'id', '0' );
        $sent = $para->addChild( 'sent' );
        $sent->addAttribute( 'id', '0' );

        for ($i = 0; $i < count($words_with_postags); $i ++) {
            $word = $sent->addChild( 'word', '' );
            $word->addAttribute( 'id', strval($i) );
            $word->addAttribute( 'cont', $words_with_postags[$i][0] );
            $word->addAttribute( 'pos', $words_with_postags[$i][1] );
        }

        return $xml4nlp;
    }
}
?>
