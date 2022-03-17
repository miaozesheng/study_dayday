package test.file_io_test.io_test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * description 字符输出流的练习
 *
 * @author miaozesheng 2022/03/15 23:08
 */
public class WriterStreamDemo {

    public static void main(String[] args) throws IOException {

        testOne();
    }

    public static void testOne() throws IOException {

        Writer writer = new FileWriter(new File("src/main/java/test/file_io_test/io_test/writerFile.txt"),true);
        writer.write('苗');
        writer.write(99);
        writer.write('x');
        writer.write("我们都是好学生!!!");

        char[] chars = "我就是这么的喜欢学习".toCharArray();
        writer.write(chars);
        writer.write("我真是太喜欢学习了",0,4);
        writer.write(chars,0,4);
        writer.flush();
        writer.close();
    }
}
