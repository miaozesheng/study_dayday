package test.file_io_test.io_test;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * description 打印流的学习
 * 打印流是最方便 最高效的打印(写)数据到文件中去 可以实现打印什么就是什么 我们之前的写法可能写a给97
 *
 * 属于字节流的 PrintStream
 * 属于字符流的 PrintWriter
 *
 * 二者在打印的时候作用是一样的,都可以打印任意数据
 * 二者的区别在于写数据,一个只能写字节,一个只能写字符
 *
 * 打印流构造器可以接受文件对象,文件路径等,可以不自己包装低级流,它底层自己封装了缓冲流
 * @author miaozesheng 2022/03/16 23:30
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws Exception {
        testPrintStream();
    }

    public static void testPrintStream() throws Exception{
        PrintStream printStream = new PrintStream("src/main/java/test/file_io_test/io_test/print_put.txt");
        printStream.println(97);
        printStream.println("lalalal");
    }

    public static void testPrintWriter() throws Exception{
        PrintWriter pr = new PrintWriter("src/main/java/test/file_io_test/io_test/print_writer.txt");
        pr.write(",");
    }

    // 把输出语句打印到文件中
    public static void printStatement() throws Exception{
        System.out.println("测试把输出语句打印到文件中!!!!!");
        PrintStream ps = new PrintStream("src/main/java/test/file_io_test/io_test/print_redirect.txt");
        System.setOut(ps); //系统打印流改为我们自己的东西
    }


}
