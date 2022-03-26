package test.annotation_test;

import java.lang.reflect.Method;

/**
 * 注解的应用场景:模拟Junit框架
 *     1.定义若干个方法,只要加了MyTestTwo注解,就可以在启动时被触发 没有这个注解该方法不能执行
 *     2.定义一个自定义注解MyTestTwo注解,只能注解方法 存活范围是一直都在
 *
 * @author miaozesheng 2022/03/22 22:33
 */
public class JunitDemoTest {

    @MyTestTwo
    public void test1(){
        System.out.println("==1111=====");
    }

    public void test2(){
        System.out.println("==1111222=====");
    }

    @MyTestTwo
    public void test3(){
        System.out.println("=333333=====");
    }

        // 启动,有注解的才被调用
    public static void main(String[] args) throws Exception {
        JunitDemoTest person = new JunitDemoTest();
        Class c = JunitDemoTest.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(MyTestTwo.class)){
                // 如果进来说明该方式上边存在这个注解,那么应该被执行
                method.invoke(person);
            }
        }
    }
}
