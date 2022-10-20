package com.bind.XPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

public class XPathGetContent {

    @Test
    public void getContent() throws DocumentException {
        SAXReader oReader =new SAXReader();

        Document oDoc = oReader.read("src/com/bind/XPath/Students.xml");

        // 分割线*10 注释 分割线*10
        System.out.println("========== 获取元素 2 的 SName ==========");

        // 获取默认( 第一个元素 )的 SName
        Node node = oDoc.selectSingleNode("/students/student/SName");
        System.out.println(node.getName());
        System.out.println(node.getText());

        // 分割线*10 注释 分割线*10
        System.out.println("========== 获取元素 2 的 SName ==========");

        // 想获取第 2 个的话也可以使用
        Node nodeTwo = oDoc.selectSingleNode("/students/student[2]/SName");
        System.out.println(nodeTwo.getName());
        System.out.println(nodeTwo.getText());

    }
}