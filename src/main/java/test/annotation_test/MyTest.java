package test.annotation_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description
 *
 * @author miaozesheng 2022/03/22 21:49
 */
@Target({ElementType.METHOD,ElementType.FIELD}) // 元注解 控制Mytest注解可以被用在那些地方
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
    /*
    Target元注解值定义中常用之如下 定义的是该注解可以被用在哪些地方 定义在ElementType枚举类中
        TYPE 类和接口上
        FIELD 成员变量上
        METHOD 成员方法上
        PARAMETER 方法参数上
        CONSTRUCTOR 构造器上
        LOCAL_VARIABLE 局部变量上

    Retention中可使用的指定以在RetentionPolicy的枚举类中,定义的是该注解可以被用在什么时候 常用值如下:
        SOURCE 注解只作用在源码阶段,生成的字节码文件中不存在
        CLASS 注解只作用在源码和字节码文件阶段 运行期间不存在 也是该元注解使用的默认值
        RUNTIME 注解作用总源码 字节码文件 及运行阶段(开发常用)
     */
}
