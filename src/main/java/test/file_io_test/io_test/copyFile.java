package test.file_io_test.io_test;

import java.io.*;

/**
 * description 模拟吧一个硬盘上的视频copy到另外一个硬盘中 使用字节流完成文件的复制
 *
 * @author miaozesheng 2022/03/15 22:07
 */
public class copyFile {
    public static void main(String[] args) {

        try{
            // 1.创建一个字节输入流和原视频接通
            InputStream inputStream = new FileInputStream("src/main/java/test/file_io_test/io_test/testOut2.txt");
            // 2.创建一个字节输入流和目标磁盘接通
            OutputStream outputStream = new FileOutputStream("src/main/java/test/file_io_test/file_test/testOut2.txt");
            // 定义一个字节数据,来转移数据
            byte[] buffer = new byte[1024];
            int len ;// 记录每次读取的字节数
            while((len = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }
            System.out.println("文件复制完成!!");
            outputStream.close();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void testCopyMe(){

        try {
            // 首先,定义一个字节输入流,读取要copy的文件
            InputStream in = new FileInputStream("");

            // 其次,定义一个字节输出流,将要copy的文件和目标位置连接起来
            OutputStream out  = new FileOutputStream("");
            // 定义一个字节数组,用以做中间数据的的存储,将读出来的文件放到这,然后转移到目标位置
            byte [] mid = new byte[1024];
            // 定义一个数字,证明每次读取的字节个数,因为不一定每次读取的都是1024的字节,比如最后剩几个的情况
            int length;

            while((length = in.read(mid))!=-1){ // 等于-1代表读完了,不等于-1那就是一直读
                out.write(mid,0,length);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
