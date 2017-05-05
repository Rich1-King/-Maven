package com.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by rich1 on 6/5/16.
 */
public class SaxForXml{
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException{
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxFactory.newSAXParser();
        parser.parse("/home/rich1/1.xml", new MySax());
    }
}

