package test.file_io_test.io_test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Properties;

/**
 * description properties 一般作为配置文件
 *
 * @author miaozesheng 2022/03/17 22:05
 */
public class PropertiesDemo {
    public static void main(String[] args) throws Exception {
        propertiesReader();
    }

    // 把东西写到文件中
    public static void propertiesWriter() throws Exception{
        Properties p = new Properties();
        p.setProperty("admin","123445");
        p.store(new FileWriter("src/main/java/test/file_io_test/io_test/pro.properties"),"保存心得!!");
    }

    // 把东西从文件中读出来
    public static void propertiesReader() throws  Exception{
        Properties p = new Properties();
        // 先把properties文件中的东西加载出来
        p.load(new FileReader("src/main/java/test/file_io_test/io_test/pro.properties"));
        System.out.println(p.getProperty("admin"));
        //IOUtils.copy(new FileInputStream("tstt.xml"),new FileOutputStream("tst.xml"));
    }
}
