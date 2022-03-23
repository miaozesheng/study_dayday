package test.xml_test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * description xpath xml信息检索技术
 * 这里只是检索有没有你想要的信息,但是不会把具体的信息解析出来
 *
 * @author miaozesheng 2022/03/23 23:40
 */
public class XPathDemo {

    @Test
    // 绝对路径查找
    public void selectByXPath1() throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new FileInputStream("src/main/java/test/xml_test/example/contact.xml"));
        // 检索全部名称
        List<Node> nodes = document.selectNodes("/contractList/contact/name");
        for (Node node : nodes) {
            Element element = (Element) node;
            System.out.println(element.getTextTrim());
        }
    }

    @Test
    // 相对路径查找
    public void selectByXPath2() throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new FileInputStream("src/main/java/test/xml_test/example/contact.xml"));
        Element root = document.getRootElement();
        List<Node> nodes = root.selectNodes("./contact/name");
        for (Node node : nodes) {
            Element element = (Element) node;
            System.out.println(element.getTextTrim());
        }
    }

    @Test
    /**
     * 全文检索
     *  //元素 在全文找这个元素
     *  //元素一/元素二 在全文找元素1下面的一级元素2
     *  //元素一//元素二 在全文找元素1下面的全部元素2
     */
    public void selectByXPath3() throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new FileInputStream("src/main/java/test/xml_test/example/contact.xml"));
//        List<Node> nodes = document.selectNodes("//name"); //可以找到西门庆
//        List<Node> nodes = document.selectNodes("//contact/name"); //找不到西门庆
        List<Node> nodes = document.selectNodes("//contact//name"); //找到西门庆
        for (Node node : nodes) {
            Element element = (Element) node;
            System.out.println(element.getTextTrim());
        }
    }

    @Test
    /**
     * 属性查找:
     *  //@属性名称 在全文检索属性对象
     *  //元素[@属性名称] 在全文检索包含该属性的元素对象
     *  //元素[@属性名称=值] 在全文检索包含该属性的元素且属性值为该值的元素对象
     */
    public void selectByXPath4() throws Exception{
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new FileInputStream("src/main/java/test/xml_test/example/contact.xml"));
        // 检索全部名称
//        List<Node> nodes = document.selectNodes("//@id");
//        for (Node node : nodes) {
//            Attribute element = (Attribute) node;
//            System.out.println(element.getName()+"===========>"+element.getValue());
//        }
//        List<Node> nodes = document.selectNodes("//name[@id]");
//        for (Node node : nodes) {
//            Element element = (Element) node;
//            System.out.println(element.getTextTrim());
//        }
        List<Node> nodes = document.selectNodes("//name[@id=999]");
        for (Node node : nodes) {
            Element element = (Element) node;
            System.out.println(element.getTextTrim());
        }

    }



}
