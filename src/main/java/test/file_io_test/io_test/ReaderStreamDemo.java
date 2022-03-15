package test.file_io_test.io_test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * description 字符流的学习,一些字节流不好做的字符流比较合适 字符流读取的最小单位是单个字符
 *
 * @author miaozesheng 2022/03/15 22:54
 */
public class ReaderStreamDemo {
    public static void main(String[] args) throws Exception {
       // testOne();
        testTwo();
    }

    // 一次读取一个字符
    public static void testOne () throws Exception {
        Reader reader = new FileReader(new File("src/main/java/test/file_io_test/io_test/test.txt"));
        // 读取单个字符
//        int read = reader.read();
//        System.out.println(read);

        // 使用循环读取字符
        int number;
        while((number = reader.read()) != -1){
            System.out.println(number);
        }
    }

    // 一次读取一个字符数组 char[] 字节数据byte[]
    public static void testTwo () throws Exception {
        Reader reader = new FileReader(new File("src/main/java/test/file_io_test/io_test/test.txt"));
//        char[] bytes = new char[3];
//        reader.read(bytes);
//        System.out.println(bytes);

        //使用循环读取
        char[] chars = new char[1024];
        int number;
        while((number = reader.read(chars)) != -1){
            System.out.println(new String(chars,0,number));
        }
    }

}
