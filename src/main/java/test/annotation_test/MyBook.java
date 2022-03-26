package test.annotation_test;

/**
 * description 自定义注解的实现
 *
 * @author miaozesheng 2022/03/22 21:35
 */
public @interface MyBook {
    // 定义具体的属性
    String name(); // 这里指的是书名
    String [] authors();
    double price();
}
