package test.file_io_test.io_test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * description 将一个乱序文章恢复到一个新文件中,并按照顺序排好
 *
 * @author miaozesheng 2022/03/16 22:17
 */
public class copyAndSort {
    public static void main(String[] args) {

        try (
                //创建字节缓冲输入流读取文件
                BufferedReader br = new BufferedReader(new FileReader("/Users/miaozesheng/Desktop/test/study_dayday/src/main/java/test/file_io_test/io_test/copyAndSort.txt"));
                // 定义缓冲字符输出流与目标文件接通,准备输出
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/test/file_io_test/io_test/copyAndSortTarget.txt"));
                ){

            //定义一个list存储每行的内容
            List<String> list = new ArrayList<>();
            // 循环读取文章
            String line;
            while((line = br.readLine()) != null){
                list.add(line);
            }
            List<String> powder = new ArrayList<>();
            Collections.addAll(powder,"一","二","三","四","五");
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    // 两行数据进来,我们自己定义比较规则 对于这种文字没法进行系统比较的,我们定义一个集合,根据索引前后来说明谁大谁小
                    //o1.substring(0,o1.indexOf("\\.")) 这部分代码取得是一二三四
                    //powder.indexOf(o1.substring(0,o1.indexOf("\\."))) 这部分代码取得是o1在一二三四五的索引位置 我们认为 索引在前的就大
                    return powder.indexOf(o1.substring(0,o1.indexOf("."))) - powder.indexOf(o2.substring(0,o2.indexOf(".")));
                }
            });
            System.out.println(list);


            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();//换行
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
