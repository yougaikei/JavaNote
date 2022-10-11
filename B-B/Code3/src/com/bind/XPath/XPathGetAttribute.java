package com.bind.XPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

public class XPathGetAttribute {

    @Test
    public void getAttribute() throws DocumentException {
        SAXReader oReader = new SAXReader();
        Document oDoc = oReader.read("src/com/bind/XPath/Students.xml");
        Node oNode = oDoc.selectSingleNode("/students/student/attribute::id");
        System.out.println(oNode.getText());

        // 查询最后一个student节点的id属性
        Node oNodeLast = oDoc.selectSingleNode("/students/student[last()]/attribute::id");
        System.out.println("最后一个 Student 的 ID 属性为: " + oNodeLast.getText());

        // 查询 id == 2 的 student 节点的 SName 属性
        Node oNodeSNameTwo = oDoc.selectSingleNode("/students/student[@id='oData2']");
        String oNameTwo = oNodeSNameTwo.selectSingleNode("SName").getText();
        String oNameTwoOf = oNodeSNameTwo.valueOf("SName");
        System.out.println("========== selectSingleNode().getText() 方法 ==========");
        System.out.println("ID 为 2 的 Student 的姓名为: " + oNameTwo);
        System.out.println("========== valueOf() 方法 ==========");
        System.out.println("ID 为 2 的 Student 的姓名为: " + oNameTwoOf);
    }
}
