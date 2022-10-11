package com.bind.DOM4J;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.util.List;

public class DOM4JGetEle {

    // 获取 XML 文档中的元素 ( ./Students.xml )
    @Test
    public void getElement() throws DocumentException {

        // 获取文档解析对象
        SAXReader reader = new SAXReader();

        // 解析 XML 文档
        Document oDoc = reader.read("./src/com/bind/DOM4J/Students.xml");

        // 获取根元素
        Element oBasicEle = oDoc.getRootElement();

        // 获取根元素名称
        String sBasicEleName = oBasicEle.getName();

        // 打印根元素名称
        System.out.println("---------- 根元素 ----------");
        System.out.println("根元素名称: " + sBasicEleName);

        // 获取根元素下的子元素
        List<Element> elements = oBasicEle.elements();
        System.out.println("---------- 子元素 ----------");
        for (Element element : elements){
            System.out.println("子元素： " + element.getName());

            List<Element> InElements = element.elements();

            System.out.println("---------- 子元素内部的元素 ----------");
            for (Element InElement : InElements){
                System.out.println("子元素的子元素： " + InElement.getName());
            }
        }

    }

}
