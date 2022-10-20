package com.bind.DOM4J;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.util.List;

public class DOM4JGetContent {

        // 获取 XML 文档中的元素内容 ( ./Students.xml )
        @Test
        public void getContent() throws DocumentException {

            // 获取文档解析对象
            SAXReader reader = new SAXReader();

            // 解析 XML 文档
            Document oDoc = reader.read("./src/com/bind/DOM4J/Students.xml");

            // 获取根元素
            Element oBasicEle = oDoc.getRootElement();

            // 获取子节点
            List<Element> elements = oBasicEle.elements();

            // 获取子节点内容 - 01
            Element oEleOne = elements.get(0);

            // 获取节点 01 的内容
            String oName = oEleOne.elementText("SName");
            String oAge = oEleOne.elementText("SAge");

            String oSex = oEleOne.element("SSex").getText();
            String oGrade = oEleOne.element("SGrade").getText();

            // 打印节点 01 的内容
            System.out.println("---------- 子元素内容 ----------");
            System.out.println("姓名: " + oName);
            System.out.println("年龄: " + oAge);
            System.out.println("性别: " + oSex);
            System.out.println("年级: " + oGrade);

        }

}
