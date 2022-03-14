package test.file_io_test.recusive_test;

import java.io.File;
import java.io.IOException;

/**
 * description
 *
 * @author miaozesheng 2022/03/14 22:38
 */
public class RecursiveFindFile {
    public static String result ;

    public static void main(String[] args) {
        String targetName = "ApiPost.app";
        System.out.println(searchFile(new File("/Applications"),targetName));
    }

    public static String searchFile(File directory,String targetName){
        if(directory!=null && directory.isDirectory()){
            File[] files = directory.listFiles();
            if(files!=null && files.length>0){
                for (File file : files) {
                    if(file.isFile()){
                        if(targetName.equals(file.getName())){
                            System.out.println(file.getAbsolutePath());
                            result = file.getAbsolutePath();
                            // 扩展,假设我们找到的是app,那么我们可以直接启动app
                            try {
                                Runtime r = Runtime.getRuntime();
                                r.exec(file.getAbsolutePath());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }else{
                        searchFile(file,targetName);
                    }
                }
            }
        }else{
            System.out.println("空空乳液");
        }
        return result;
    }
}
