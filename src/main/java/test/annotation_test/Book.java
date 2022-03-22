package test.annotation_test;

/**
 * description
 *
 * @author miaozesheng 2022/03/22 21:42
 */
public @interface Book {
    String value();//特殊属性测试 如果还有其他参数,那么value必须指定
    double price() default 9.9;
}
