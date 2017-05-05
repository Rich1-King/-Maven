package com.xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySax extends DefaultHandler
{
    public void startDocument()
    {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }

    public void endDocument()
    {
        System.out.println("\n　文档结束");
    }

    public void startElement(String uri, String localName, String name,
                             Attributes attributes)
    {
        System.out.print("<");
        System.out.print(name);

        if(attributes != null)
        {
            for(int i = 0; i < attributes.getLength(); i++)
            {
                System.out.print(" " + attributes.getQName(i) + "= " +
                        attributes.getValue(i) + "\" ");
            }
        }
        System.out.println(">");
    }

    public void endElement(String uri, String localName, String name)
    {
        System.out.print("</");
        System.out.print(name);
        System.out.println(">");
    }

    public void characters(char[] ch, int start, int length)
    {
        System.out.println(new String(ch, start, length));
    }

}
