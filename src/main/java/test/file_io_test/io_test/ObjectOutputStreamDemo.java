package test.file_io_test.io_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * description 对象序列化和对象反序列化 是两个字节流的实现类
 *
 * ObjectOutputStream 序列化 对象存储到硬盘
 * ObjectInputStream 反序列化 对象从硬盘中读取出来
 * @author miaozesheng 2022/03/16 23:01
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws Exception{
        Person p = new Person("miao",12,true);

        //testObjectOutputStream(p);
        testObjectInputStream();
    }
    // 另外,对象如果要序列化,那么一定要实现序列化接口 Serializable

    public static void testObjectOutputStream(Person person) throws Exception{
        Person p2= new Person("miaoze",13,true);
        // 对象的序列化,使用高级流包装低级流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/test/file_io_test/io_test/ojbect_put.txt"));
        // 调用高级流的序列化方法
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,person,p2);
        oos.writeObject(list);
        oos.close();
    }

    public static void testObjectInputStream() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/test/file_io_test/io_test/ojbect_put.txt"));
        List<Person> list = (List<Person>) ois.readObject();
        for (Person p : list) {
            System.out.println(p);
        }
        ois.close();
    }
}
