package test.xml_test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * description 使用dom4j解析xml文件中的数据
 * 1.导入dom4j
 * 2.准备一个xml文件
 *
 *
 * @author miaozesheng 2022/03/23 22:43
 */
public class DOM4JDemo {

    @Test
    public void parseDom4j() throws Exception{
        // 1.创建一个dom4j的解析器对象 代表了整个dom4j
        SAXReader saxReader = new SAXReader();
        // 2.吧xml文件加载到内存中成为一个Document文档对象
        Document document = saxReader.read(new File("src/main/java/test/xml_test/example.xml"));
        // 3.获取根元素对象
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());

        // 4.拿根元素下的其他子元素
        List<Element> sonElements = rootElement.elements();
        for (Element sonElement : sonElements) {
            System.out.println(sonElement.getName());
            System.out.println(sonElement.elementText("name"));
            System.out.println(sonElement.elementText("age"));
            Attribute attribute = sonElement.attribute("id");
            System.out.println(attribute.getValue()+attribute.getName());
            Attribute attribute1 = sonElement.attribute("vip");
            System.out.println(attribute1.getValue()+attribute1.getName());
        }


    }

}
