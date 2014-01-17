require 'rexml/document'
require 'builder'

REXML::Attribute.class_eval( %q^
  def to_string
    %Q[#@expanded_name="#{to_s().gsub(/"/, '&quot;')}"]
  end
^)

class LTML
  def initialize(xmlstr = nil)
    unless xmlstr.nil?
      @doc = REXML::Document.new(xmlstr)
      #@doc.context[:attribute_quote] = :quote
    end
  end

  def build(sentence, encoding = 'UTF-8')
    buffer = ""
    xml = Builder::XmlMarkup.new(:target => buffer, :indent => 2)
    xml.instruct! :xml, :encoding => encoding
    xml.xml4nlp do |xml4nlp|
      xml4nlp.note(:sent => 'n',
                   :word => 'n',
                   :pos => 'n',
                   :parser => 'n',
                   :ne => 'n',
                   :wsd => 'n',
                   :srl => 'n')
      xml4nlp.doc do |doc|
        doc.para do |para|
          para.sent(:id => '0', :cont => sentence)
        end
      end
    end
    @doc = REXML::Document.new(buffer)
  end

  def build_from_words(words, encoding = 'UTF-8')
    buffer = ""
    sentence = words.join("")
    xml = Builder::XmlMarkup.new(:target => buffer, :indent => 2)
    xml.instruct! :xml, :encoding => encoding
    xml.xml4nlp do |xml4nlp|
      xml4nlp.note(:sent => 'y',
                   :word => 'y',
                   :pos => 'n',
                   :parser => 'n',
                   :ne => 'n',
                   :wsd => 'n',
                   :srl => 'n')
      xml4nlp.doc do |doc|
        doc.para do |para|
          para.sent :id => 0, :cont => sentence  do |sent|
            words.each_index do |i|
              sent.word(:id => i, :cont => words.fetch(i))
            end
          end
        end
      end
    end
    @doc = REXML::Document.new(buffer)
  end

  def build_from_words_with_postags(words_with_postags, encoding = 'UTF-8')
    buffer = ""
    sentence = words_with_postags.map{|word| word[0]}.join("")
    xml = Builder::XmlMarkup.new(:target => buffer, :indent => 2)
    xml.instruct! :xml, :encoding => encoding
    xml.xml4nlp do |xml4nlp|
      xml4nlp.note(:sent => 'y',
                   :word => 'y',
                   :pos => 'y',
                   :parser => 'n',
                   :ne => 'n',
                   :wsd => 'n',
                   :srl => 'n')
      xml4nlp.doc do |doc|
        doc.para do |para|
          para.sent :id => 0, :cont => sentence  do |sent|
            words_with_postags.each_with_index do |val, i|
              sent.word(:id => i,
                    :cont => val[0],
                    :pos => val[1])
            end
          end
        end
      end
    end
    @doc = REXML::Document.new(buffer)
  end

  def to_s
    @doc.to_s
  end
end
