package test.file_io_test.io_test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * description 字符集的学习
 * ASCII 包括了数字,英文,符号 使用一个字节存储一个字符,一个字节是8位,总共可以标识128个字符信息
 * GBK 包含了几万个汉子,支持繁体子及部分日韩文字 一个中文以两个字节的形式存储 英文仍然使用一个字节进行存储 兼容ASCII编码
 * Unicode 统一码,万国码 计算机科学领域里边的编码标准 utf-8 utf-16 utf-32等 utf-8中 一个中文用三个字节存储 兼容了ASCII编码
 *
 * 英文 数字在任意字符集中,都只占一个字节
 * @author miaozesheng 2022/03/14 23:22
 */
public class CharSetDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 编码和解码
        in();
        en();
    }

    // 编码,文字转换成字节
    // 中文编码之后都是复数,这也是解码时区别是中文还是英文的方式
    public static void in() throws UnsupportedEncodingException {
        String str = "我爱你中国abc";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //也可以声明成其他编码方式
        byte[] bytes2 = str.getBytes("GBK");
        System.out.println(bytes.length);//18
        System.out.println(bytes);//[B@1be6f5c3
        System.out.println(Arrays.toString(bytes));//[-26, -120, -111, -25, -120, -79, -28, -67, -96, -28, -72, -83, -27, -101, -67, 97, 98, 99]
        System.out.println(bytes2.length);//13
        System.out.println(bytes2);//[B@6b884d57
        System.out.println(Arrays.toString(bytes2));//[-50, -46, -80, -82, -60, -29, -42, -48, -71, -6, 97, 98, 99]

    }

    // 转码 字节转换成文字
    // 我们需要注意,编码方式和解码方式必须一直,不然解码的时候会出现乱码的情况
    public static void en() throws UnsupportedEncodingException {
        String str = "我爱你中国abc";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //也可以声明成其他编码方式
        byte[] bytes2 = str.getBytes("GBK");
        String result = new String(bytes);
        String result2 = new String(bytes2);
        System.out.println(result);//我爱你中国abc
        System.out.println(result2);//�Ұ����й�abc 使用utf-8解码,然后使用gbk进行编码,最后解码时就会乱码 这里string默认使用的解码方式是utf-8
    }

}
