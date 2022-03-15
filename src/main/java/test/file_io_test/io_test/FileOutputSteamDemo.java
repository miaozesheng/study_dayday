package test.file_io_test.io_test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * description 文件字节输出流 写到文件中
 *
 * @author miaozesheng 2022/03/15 21:43
 */
public class FileOutputSteamDemo {

    public static void main(String[] args) throws Exception{
        testOne();
        testTwo();
        testThree();
    }
    public static void testOne() throws Exception{
        OutputStream outputStream = new FileOutputStream("src/main/java/test/file_io_test/io_test/testOut.txt");
        //write是写一个字节进去
        outputStream.write('a');
        outputStream.write('苗');
        outputStream.write(98);
        // 进行刷新,防止系统缓存,未真正写入磁盘中
        //outputStream.flush();
        //释放资源 释放资源的过程是包含刷新的,关闭之后流不能使用,刷新之后流还可以使用
        outputStream.close();
    }

    public static void testTwo() throws Exception{
        OutputStream outputStream = new FileOutputStream("src/main/java/test/file_io_test/io_test/testOut2.txt");
        outputStream.write(new byte[]{'a', 'b', 'c', 'd'});

        //或者我们可以直接把中文转成字节数据之后进行写入,中文就不会乱码
        byte[] bytes = "我喜欢学习".getBytes(StandardCharsets.UTF_8);
        outputStream.write(bytes);
        // 把换行写进去
        outputStream.write("\r\n".getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    public static void testThree() throws Exception{

    }
}
