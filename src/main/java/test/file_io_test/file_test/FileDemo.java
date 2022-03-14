package test.file_io_test.file_test;

import java.io.File;

/**
 * description
 *
 * @author miaozesheng 2022/03/14 21:34
 */
public class FileDemo {

    public static void main(String[] args) {
        /**
         * 路径的写法 windows的写法:
         * 1.D:\\resources\\xxx.jpeg
         * 2.D:/resource/xxx.jpeg
         * 两种写法都可以 问题是如果是其他系统 如linux或者是mac系统,不知道具体分隔符是什么
         * 使用该方法 File.separator来获取系统的分隔符 如
         */


        // 获取file对象
        File file = new File("/Users/miaozesheng/Desktop/QQ20210814-171351@2x的副本.png");
        File file2 = new File(File.separator+"Users"+File.separator+"miaozesheng"+File.separator+"Desktop"+File.separator+"QQ20210814-171351@2x的副本.png");
        long length = file.length(); // 文件的字节大小
        System.out.println(length);
        System.out.println(file2.length());

        // file获取对象,支持相对方路径,也支持相对方路径 java中的相对方路径是工程下
        File file3 = new File("README.md");
        System.out.println(file3.length());

        // file创建对象,可以是一个文件,也可以是一个文件夹 文件或者文件夹,可以存在也可以不存在

        // 两个简单api的使用 分别为返回名字和返回文件对象 遍历一级文件对象
        File f4 = new File("/Users/miaozesheng/Desktop/linux");
        String [] names = f4.list();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("====================");
        File [] files = f4.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }
}
