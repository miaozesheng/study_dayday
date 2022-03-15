package test.file_io_test.io_test;

import java.io.*;

/**
 * description 资源释放 正常来说,流的操作会有很多编译器异常,我们会把这些异常抓起来
 * 最后进行资源释放的时候,我们应该将资源释放的语句写到finally块中比较合适
 *
 * @author miaozesheng 2022/03/15 22:23
 */
public class ResourceFree {
    public static void main(String[] args) {
        resourceFree();
    }

    // 普通的资源释放
    public static void resourceFree(){
        InputStream in = null;
        OutputStream out = null;
        try {
            // 首先,定义一个字节输入流,读取要copy的文件
            in = new FileInputStream("");

            // 其次,定义一个字节输出流,将要copy的文件和目标位置连接起来
            out  = new FileOutputStream("");
            // 定义一个字节数组,用以做中间数据的的存储,将读出来的文件放到这,然后转移到目标位置
            byte [] mid = new byte[1024];
            // 定义一个数字,证明每次读取的字节个数,因为不一定每次读取的都是1024的字节,比如最后剩几个的情况
            int length;

            while((length = in.read(mid))!=-1){ // 等于-1代表读完了,不等于-1那就是一直读
                out.write(mid,0,length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 这里关闭之前,先进行非空校验,防止管道创建出来之前就已经刷满了异常
            try {
                if(out!=null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(in!=null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 这里说一个面试题
    public static int interview(int a , int b){
        // 如果我们在finally中写了return语句,那么即使没有出现异常,最后系统也只会执行finally中的return 这种情况可能会导致数据异常,不建议这么写,但是面试这么搞
        // 另外,有一个关闭Java虚拟机的方法,可以比return还牛逼,先结束
        //System.exit(0);
        try {
            int c = a/b;
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return 1000;
        }finally {
            return 100;
        }
    }

    // jdk7针对于资源释放,优化的资源释放方法
    public static void resourceFreeJdk7(){
        // try(资源放入到这里){}  括号里边只能放置资源,资源都实现了closeable接口 这种实现方式最后后自动关闭字段,不需要我们手动关闭
        try(// 1.创建一个字节输入流和原视频接通
            InputStream inputStream = new FileInputStream("src/main/java/test/file_io_test/io_test/testOut2.txt");
            // 2.创建一个字节输入流和目标磁盘接通
            OutputStream outputStream = new FileOutputStream("src/main/java/test/file_io_test/file_test/testOut2.txt");
            ){

            // 定义一个字节数据,来转移数据
            byte[] buffer = new byte[1024];
            int len ;// 记录每次读取的字节数
            while((len = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }
            System.out.println("文件复制完成!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // jdk9 针对于资源释放的优化 不建议用!!! 如果是别人送过来的,那用起来还是比较合适的
    public static void resourceFreeJdk9() throws FileNotFoundException {
        // 1.创建一个字节输入流和原视频接通
        InputStream inputStream = new FileInputStream("src/main/java/test/file_io_test/io_test/testOut2.txt");
        // 2.创建一个字节输入流和目标磁盘接通
        OutputStream outputStream = new FileOutputStream("src/main/java/test/file_io_test/file_test/testOut2.txt");

        // 这种资源也会最终关闭,但是看起来怪怪的,最后异常还要跑出去,或者创建流的时候还要自己捕获,好处是下边可以直接用了,不需要提前定义了
        try(inputStream;outputStream){
            // 定义一个字节数据,来转移数据
            byte[] buffer = new byte[1024];
            int len ;// 记录每次读取的字节数
            while((len = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }
            System.out.println("文件复制完成!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
