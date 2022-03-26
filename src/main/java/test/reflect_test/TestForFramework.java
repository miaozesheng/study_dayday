package test.reflect_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

/**
 * description 提供一个框架,支持保存所有对象的具体信息
 *
 * @author miaozesheng 2022/03/21 23:37
 */
public class TestForFramework {
    public static void main(String[] args) throws Exception{
        Student s = new Student("11","33","22");
        Teacher t = new Teacher("miao",24,true);
        save(s);
        save(t);
    }

    public static void save(Object o) throws Exception{
        PrintStream printStream = new PrintStream(new FileOutputStream("src/main/java/test/reflect_test/reflect2.txt",true));
        Class c = o.getClass();
        c.getName();//获取全限定类名
        c.getSimpleName();//获取类名
        printStream.println("============"+c.getSimpleName()+"==============");
        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
           declaredField.setAccessible(true);
           // 获取成员变量的字段名称
           String name = declaredField.getName();
           // 获取成员变量的值 要给一个对象,就是我们传进来o 你需要拿的是某一个对象的成员变量及他的值
           String value = declaredField.get(o)+"";
           printStream.println(name+"="+value);
        }
        printStream.close();
    }
}
