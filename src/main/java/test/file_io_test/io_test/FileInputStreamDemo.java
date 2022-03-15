package test.file_io_test.io_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * description 读内容出来
 *
 * @author miaozesheng 2022/03/15 21:13
 */
public class FileInputStreamDemo {

    public static void main(String[] args) throws Exception {
       // testOne();
        //testTwo();
        testThree();

    }

    // 字节输入流的测试,每次读取一个字节
    public static void testOne() throws Exception{
        // 文件字节输入流练习
        InputStream inputStream = new FileInputStream(new File("src/main/java/test/file_io_test/io_test/test.txt"));
        // 读取一个字节返回 read方法每次只读取一个字节 读取完毕还要读那么返回-1
        int b1 = inputStream.read();
        System.out.println(b1);

        while(inputStream.read()!=-1){
            System.out.println(inputStream.read());
        }
    }

    // 字节输入流的测试,每次读取多个字节
    public static void testTwo() throws Exception{
        InputStream inputStream = new FileInputStream(new File("src/main/java/test/file_io_test/io_test/test.txt"));
        byte[] buffer = new byte[3]; // 如果是1024 代表一次读1024个字节
//        while(inputStream.read(buffer)!=-1){
//            int len = inputStream.read(buffer);
//            System.out.println("读取的字节个数为"+len);
//            System.out.print(new String(buffer,0,len));
//
//        }
        int len;
        // 每次读都是上一次读了剩余的内容 存在问题,中文字符可能乱码
        while((len = inputStream.read(buffer)) != -1){
            System.out.println(new String(buffer,0,len));
        }

    }

    // 使用字节输入流 避免出现乱码 解决办法:一次性读完所有字节
    public static void testThree() throws Exception{
        File f = new File("src/main/java/test/file_io_test/io_test/test.txt");
        byte [] buffer = new byte[(int)f.length()];
        InputStream in = new FileInputStream(f);
//        in.read(buffer);
//        System.out.println(new String(buffer));


        // 或者使用官网提供的api,直接读取全部
        byte[] byte2 = in.readAllBytes();
        System.out.println(new String(byte2));

    }

}
