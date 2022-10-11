package com.bind.DOM4J;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.util.List;

public class DOM4JGetAttribute {

    // 获取 XML 文档中的元素属性 ( ./Students.xml )
    @Test
    public void getAttribute() throws DocumentException {

        // 获取文档解析对象
        SAXReader reader = new SAXReader();

        // 解析 XML 文档
        Document oDoc = reader.read("./src/com/bind/DOM4J/Students.xml");

        // 获取根元素
        Element oBasicEle = oDoc.getRootElement();

        // 获取子节点
        List<Element> elements = oBasicEle.elements();

        // 获取子节点内容 - 01
        Element oEleOne = elements.get(0); // Students => Student[0] || Student.length == 1

        // 获取节点 01 的属性 => students => student[id=?]
        String oID = oEleOne.attributeValue("id");

        // 打印节点 01 的属性
        System.out.println("---------- 子元素属性 ----------");
        System.out.println("子元素属性: " + oID);

    }

}
