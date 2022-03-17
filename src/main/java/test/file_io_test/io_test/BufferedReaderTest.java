package test.file_io_test.io_test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * description 字符缓冲流的练习(经典代码)
 *
 * @author miaozesheng 2022/03/16 22:06
 */
public class BufferedReaderTest {
    public static void main(String[] args) {
        testOne();
    }

    //测试字符缓冲输入流特有的读一行数据的功能
    public static void testOne(){
        try {
            Reader reader = new FileReader("src/main/java/test/file_io_test/io_test/test.txt");
            BufferedReader rd = new BufferedReader(reader);

            /** 这么写会有死循环 注意 读的操作应该放到while中
             * String line = rd.readLine();
             * while(line != null){
             *     System.out.println(line);
             * }
             */

            String line;
            while((line = rd.readLine()) != null){
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
