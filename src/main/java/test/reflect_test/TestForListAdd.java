package test.reflect_test;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * description 使用反射逃过编译阶段为集合添加数据 反射作用在运行时的技术,此时集合的泛型不能产生约束了,可以为集合存入其他任意类型的值
 * 我们的java文件在编译成class文件进入运行阶段的时候,泛型限制的具体类型已经被擦除掉了
 *
 * @author miaozesheng 2022/03/21 23:13
 */
public class TestForListAdd {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        System.out.println(integerList.getClass()); //class java.util.ArrayList
        System.out.println(stringList.getClass());//class java.util.ArrayList

        System.out.println(integerList.getClass() == stringList.getClass());// true 证明获取两个不同的arraylist的都存储的是ArrayList.class
        integerList.add(1);
        integerList.add(2);
        Class c = integerList.getClass();
        Method add = c.getDeclaredMethod("add",Object.class);
        add.setAccessible(true);
        boolean flag = (boolean) add.invoke(integerList,"string");
        System.out.println(flag);
        System.out.println(integerList);

        test();
    }
    // 这里提供另外一种突破集合泛型的约束 但是这里不能使用多态创建
    public static void test(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        ArrayList list2 = integerList;
        // 这里integerlsit 和list2指向的是一个地址
        list2.add("string");
        list2.add(false);
        System.out.println(integerList);


    }
}
