package test.file_io_test.io_test;

import java.io.*;

/**
 * description 转换流的练习,主要是解决文件编码不一致的问题.
 * 比如别人给你一个文件,他使用的是GBK编码,你使用的是utf-8的代码 那么就会出现乱码的情况,这时候我们就需要使用转换流了
 *
 * 两个字符转换流
 * InputStreamReader 做法就是把原始的字节流按照指定编码转换成字符输入流
 * OutputStreamWriter
 *
 * @author miaozesheng 2022/03/16 22:39
 */
public class TransformStreamDemo {

    // 字符输入转换流的学习 InputStreamReader
    // 假设外边给我们的文件data.txt是GBK编码的文件,我们系统里边都是utf-8编码的格式
    public static void test() throws Exception {
        //1.提取gbk编码的原始字节流
        InputStream is = new FileInputStream("D:\\resources\\data.txt");
        //2.把原始字节流转换成字符输入流
       // Reader reader = new InputStreamReader(is);//这里使用默认规则,用utf-8的方式将原始字节流转换为字符流,还是会乱码的
        // 我们指定一个编码 以指定的编码进行将原始字节流转换成字符流
        Reader reader = new InputStreamReader(is,"gbk");
        BufferedReader br = new BufferedReader(reader);
        while(br.readLine()!=null){
            System.out.println(br.readLine());
        }
    }


    // 字符输出转换流的学习 OutputStreamWriter
    // 假设我们系统的编码utf-8的编码格式,外部系统要求给他们的文件编码格式必须是gbk的
    public static void testTwo() throws Exception {
        // 1.定义一个字节输出流
        OutputStream os = new FileOutputStream("tst.txt");
        // 2.吧原始的字节输出流转换成字符输出流
        //Writer osw = new OutputStreamWriter(os);// 使用默认规则,使用utf-8的方式将原始字节流转换为字符类,还是会乱码
        Writer osw = new OutputStreamWriter(os,"gbk");//以指定gbk编码方式写出
        BufferedWriter bufferedWriter = new BufferedWriter(osw);
        bufferedWriter.write("我爱我的祖国");
        bufferedWriter.close();
    }
}
