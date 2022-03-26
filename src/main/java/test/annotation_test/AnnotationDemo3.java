package test.annotation_test;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * description 学习注解的解析
 *
 * 案例实现:
 *  1.定义注解Desk 包含属性 String value() double price() 默认值100 String[] authors()
 *  2.限制注解使用的位置 类和成员方法上
 *  3.限制注解的有效范围 RUNTIME
 *  4.定义BookStore类 在类和成员方法上使用注解
 *  5.定义AnnotationDemo3 测试类获取Book注解上的数据
 *
 * @author miaozesheng 2022/03/22 22:08
 */
public class AnnotationDemo3 {
    @Test
    public void parsClass(){
        Class c = BookStore.class;
        // 判断当前类上边是否存在某个注解
        if(c.isAnnotationPresent(Desk.class)){
            Desk desk =(Desk) c.getDeclaredAnnotation(Desk.class);
            System.out.println(desk.value());
            System.out.println(desk.price());
            System.out.println(Arrays.toString(desk.authors()));
        }

    }
    @Test
    public void parseMethod() throws Exception{
        Class c = BookStore.class;
        Method method = c.getDeclaredMethod("test");
        method.setAccessible(true);
        if(method.isAnnotationPresent(Desk.class)){
            Desk desk = (Desk) method.getDeclaredAnnotation(Desk.class);
            System.out.println(desk.price());
            System.out.println(desk.value());
            System.out.println(Arrays.toString(desk.authors()));
        }
    }
}
