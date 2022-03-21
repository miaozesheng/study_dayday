package test.reflect_test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * description 使用反射拿到相关信息
 *
 * @author miaozesheng 2022/03/21 22:06
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception {
//        getClassTest();
//        getConstructorTest();
        //testGetField();
        testGetMethod();
    }

    public static void getClassTest() throws Exception{
        // 第一种方式  源代码阶段
        Class c = Class.forName("test.reflect_test.Student");
        System.out.println(c);// class test.reflect_test.Student

        // 第二种方式 class对象阶段
        Class c2 = Student.class;
        System.out.println(c2);

        // 第三种方式 runtime运行时阶段
        Class c3 = new Student().getClass();
        System.out.println(c3);

    }

    // 通过反射获取构造器对象并且使用该构造器创建对象
    public static void getConstructorTest() throws Exception{

        Class c = Student.class;

        // 获取构造器对象数据(可能存在多个构造器) 这里只能拿到public的构造器
        Constructor<?>[] constructorList =  c.getConstructors();
        for (Constructor<?> constructor : constructorList) {
            System.out.println(constructor.getName()+"======>"+constructor.getParameterCount());
        }
        System.out.println("==================================");
        // 获取所有构造器对象 只要存在就能拿到
        Constructor<?>[] constructorList2 = c.getDeclaredConstructors();
        for (Constructor<?> constructor : constructorList2) {
            System.out.println(constructor.getName()+"======>"+constructor.getParameterCount());
        }
        System.out.println("==================================");
        // 找单个构造器,根据只能找到单个公开的构造器
        Constructor constructor = c.getConstructor();
        System.out.println(constructor.getName()+"======>"+constructor.getParameterCount());
        System.out.println("==================================");
        // 找单个构造器,根据参数找到任意构造器
        Constructor constructor1 = c.getDeclaredConstructor();
        System.out.println(constructor.getName()+"======>"+constructor.getParameterCount());
        // 找单个构造器,根据参数匹配
        Constructor constructor2 = c.getConstructor(String.class,String.class,String.class);
        System.out.println(constructor.getName()+"======>"+constructor.getParameterCount());

        // 使用单个构造器进行对象的创建
        Student student = (Student)constructor2.newInstance("22", "22", "2");

        // 另外,如果遇到构造器为私有的时候,可以进行暴力反射
        constructor2.setAccessible(true);// 即打开可以被发现的权限
    }

    // 获取成员变量 可以反射之后进行取值和复制
    public static void testGetField() throws Exception{


        Class c = Student.class;
        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField +"========>" + declaredField.getType());
        }

        Field field = c.getDeclaredField("sfs2");
        Field field1 = c.getDeclaredField("sfs");
        Field field2 = c.getDeclaredField("ss1");
        System.out.println(field2);
        field2.setAccessible(true);
        Student student = new Student();
        // 给成员变量赋值,因为这个成员变量是属于某个对象的,所以需要把要给的值和要给值的对象都给到set方法
        System.out.println(field2.get(student));
        field2.set(student,"miao");
        // 取成员变量的值
        String s = (String)field2.get(student);
        System.out.println(s);
        System.out.println(field1);
        System.out.println(field2);

    }

    // 获取成员方法 并调用方法
    public static void testGetMethod() throws Exception{
        Class c = Student.class;
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod+"========>"+declaredMethod.getName());
        }
        System.out.println("==================");
        Method method = c.getDeclaredMethod("testS3",String.class);
        method.setAccessible(true);
        System.out.println(method+"======>"+method.getName()+method.getParameterTypes());

        // 调用实例方法 使用invoke来实现
        // 参数1 该方法所属的obj对象 参数2 调用方法传递的参数 如果没有就不写
        Student student = new Student();
        method.invoke(student,"miaomoumou");

    }

}
