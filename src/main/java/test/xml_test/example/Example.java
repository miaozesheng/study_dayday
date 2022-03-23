package test.xml_test.example;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * description 使用dom4j,将xml文件中的联系人数据封装成list集合 并打印输出
 *
 * @author miaozesheng 2022/03/23 23:14
 */
public class Example {

    @Test
    public void parseContactsList() throws Exception{

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new FileInputStream("src/main/java/test/xml_test/example/contact.xml"));
        List<Contact> contacts = new ArrayList<>();
        Element rootElement = document.getRootElement();

        List<Element> contactElements = rootElement.elements("contact");
        for (Element contactElement : contactElements) {
            Contact contact = new Contact();
            contact.setId(Integer.parseInt(contactElement.attributeValue("id")));
            contact.setVip(Boolean.parseBoolean(contactElement.attributeValue("vip")));
            contact.setName(contactElement.elementTextTrim("name"));
            contact.setGender(contactElement.elementTextTrim("gender"));
            contact.setEmail(contactElement.elementTextTrim("email"));
            contacts.add(contact);
        }

        System.out.println(contacts);
    }
}
