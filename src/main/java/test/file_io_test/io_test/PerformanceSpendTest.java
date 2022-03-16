package test.file_io_test.io_test;

import java.io.*;
import java.text.FieldPosition;

/**
 * description 进行性能测试
 *
 * @author miaozesheng 2022/03/16 21:23
 */
public class PerformanceSpendTest {

    public static void main(String[] args) {
        //testOne(); // 慢到令人发指,直接放弃等待
        //testTwo(); // 第二快
        //testThree();// 第三快
        testFour(); // 效率最高
    }

    //使用低级的字节流按照一个一个字节复制的方式复制文件
    public static void testOne(){

        long startTime = System.currentTimeMillis();
        try(InputStream is = new FileInputStream(new File("/Users/miaozesheng/Downloads/SOLARIS.X64_195000_db_home.zip"));
            OutputStream os = new FileOutputStream(new File("/Users/miaozesheng/Downloads/test11111_db_home.zip"));) {
            int len ;
            while((len = is.read()) != -1){
                os.write(len);
            }
            System.out.println("复制完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("低级字节流单个字节复制花费了多少秒:"+(endTime-startTime)/1000);
    }

    // 使用低级的字节流按照一个一个字节数组的方法复制文件
    public static void testTwo(){
        long startTime = System.currentTimeMillis();

        try {
            InputStream is = new FileInputStream(new File("/Users/miaozesheng/Downloads/SOLARIS.X64_195000_db_home.zip"));
            OutputStream os = new FileOutputStream(new File("/Users/miaozesheng/Downloads/test2222_db_home.zip"));
            byte [] bytes = new byte[1024 * 8];
            int len;
            while((len = is.read(bytes)) != -1){
                os.write(bytes,0,len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("低级字节流单个字节数组复制花费了多少秒:"+(endTime-startTime)/1000);
    }

    // 使用高级的缓冲流一个一个字节的复制文件
    public static void testThree(){
        long startTime = System.currentTimeMillis();

        try(
                InputStream is = new FileInputStream(new File("/Users/miaozesheng/Downloads/SOLARIS.X64_195000_db_home.zip"));
                OutputStream os = new FileOutputStream(new File("/Users/miaozesheng/Downloads/test33333_db_home.zip"));
                InputStream bis = new BufferedInputStream(is);
                OutputStream bos = new BufferedOutputStream(os);
                ) {

            int len;
            while(bis.read() != -1){
                bos.write(bis.read());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("高级缓冲流单个字节复制花费了多少秒:"+(endTime-startTime)/1000);
    }

    // 使用高级的缓冲流一个一个字节数据的方式复制文件
    public static void testFour(){
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        try(
                InputStream is = new FileInputStream(new File("/Users/miaozesheng/Downloads/SOLARIS.X64_195000_db_home.zip"));
                OutputStream os = new FileOutputStream(new File("/Users/miaozesheng/Downloads/test4444_db_home.zip"));
                InputStream bis = new BufferedInputStream(is);
                OutputStream bos = new BufferedOutputStream(os);
                ) {
            System.out.println("2222222");
            int len;
            byte [] bytes = new byte[1024];
            while((len = bis.read()) != -1){
                bos.write(bytes,0,len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("高级缓冲流单个字节数组复制花费了多少秒:"+(endTime-startTime)/1000);
    }
}
