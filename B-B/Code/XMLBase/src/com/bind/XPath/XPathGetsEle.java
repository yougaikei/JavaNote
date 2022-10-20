package com.bind.XPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.util.List;

public class XPathGetsEle {

    public Document setXml() throws DocumentException {
        SAXReader oReader = new SAXReader();
        Document document = oReader.read("src/com/bind/XPath/Students.xml");
        return document;
    }

    // 获取所有节点
    @Test
    public void getAllEle() throws DocumentException {

        Document oDoc = setXml();

        // 获取所有节点
        List<Node> oEleList = oDoc.selectNodes("//*");

        // 获取所有节点的个数
        System.out.println("所有节点的个数：" + oEleList.size());

        // 输出所有节点的名称
        for (Node oNode : oEleList) {
            System.out.println(oNode.getName());
        }
    }

    @Test
    public void getStudentsSName() throws DocumentException {

        Document oDocument = setXml();

        // 获取所有学生的名字
        List<Node> oNameList = oDocument.selectNodes("//SName");

        // 打印结果
        for (Node oNode : oNameList) {
            System.out.println("姓名: " + oNode.getText());
        }
    }

    @Test
    public void getOneStudentsData() throws DocumentException {

        // 输出 01 学生的所有信息
        Document oDocument = setXml();

        List oStudentOne = oDocument.selectNodes("/students/student//*");

        for (Object oNode : oStudentOne) {
            System.out.println(((Node) oNode).getName() + ": " + ((Node) oNode).getText());
        }

    }

}
