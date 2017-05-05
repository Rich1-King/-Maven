package com.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by rich1 on 6/5/16.
 */
public class DomForXml{

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException{

       //创建xml文件
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument(); //创建整个文档，代表整个xml文件
        Element ele1 = doc.createElement("Perosn"); //根元素(dom中创建文件的元素的方法,
                                                    // Elemment继承与Node)
        Element ele11 = doc.createElement("Man");
        Element ele12 = doc.createElement("WoMan");
        Element ele111 = doc.createElement("Name");
        Element ele112 = doc.createElement("Sex");
        Element ele121 = doc.createElement("Name");
        Element ele122 = doc.createElement("Sex");
        ele111.setAttribute("me","hello");
        Text name = doc.createTextNode("张三");
        Text sex = doc.createTextNode("男");
        Text sex2 = doc.createTextNode("女");

        ele111.appendChild(name);
        ele112.appendChild(sex);

        ele121.appendChild(name);
        ele122.appendChild(sex2);

        ele11.appendChild(ele111);
        ele11.appendChild(ele112);
        ele1.appendChild(ele11);

        ele12.appendChild(ele121);
        ele12.appendChild(ele122);
        ele1.appendChild(ele12);

        doc.appendChild(ele1);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        DOMSource dom = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("/home/rich1/1.xml"));
        t.transform(dom, result);       //生成xml文件

        //读取xml文件内容
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document d = db.parse("/home/rich1/1.xml");
        NodeList nl =  d.getElementsByTagName("WoMan");
        Element e = (Element) nl.item(0);
        System.out.println(e.getElementsByTagName("Name").item(0)
                .getLastChild().getNodeValue());
    }
}
