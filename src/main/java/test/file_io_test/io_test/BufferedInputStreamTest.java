package test.file_io_test.io_test;

import java.io.*;

/**
 * description 缓is输入流
 *
 * @author miaozesheng 2022/03/16 21:07
 */
public class BufferedInputStreamTest {
    /**
     * 缓冲流的好处:自带缓冲区,操作效率比字节流和字符流要快 字节流和字符流被称为原始流,而且缓冲流被称为高级流 自带8kb缓冲池
     * 字节缓冲流 字符缓冲流
     */
    public static void main(String[] args) {
        testOne();
    }

    public static void testOne() {
        try(
                InputStream is = new FileInputStream("src/main/java/test/file_io_test/io_test/test.txt");
                InputStream bis = new BufferedInputStream(is);
                OutputStream os = new FileOutputStream("src/main/java/test/file_io_test/io_test/testBuffered.txt");
                OutputStream bos = new BufferedOutputStream(os);
                ){
            byte [] bytes = new byte[1024];
            int len ;
            while((len = bis.read(bytes)) != -1){
                bos.write(bytes,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
