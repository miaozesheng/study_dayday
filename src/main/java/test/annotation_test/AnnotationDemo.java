package test.annotation_test;

/**
 * description 注解可以标记在类 方法 构造器 参数 成员变量上
 * 特殊属性 value 如果只有一个value属性的情况下,使用value属性的时候可以省略不写
 * 如果有多个属性 且多个属性没有默认值 那么value名称是不能省略的 但是如果其他属性有默认值的话,那么又可以省略
 *
 * @author miaozesheng 2022/03/22 21:38
 */
@MyBook(name="<<学习每一天>>",authors = {"44","miao"},price = 14)
//@Book("delete")//@Book(value = "delete")
@Book(value = "22",price = 11.33)
public class AnnotationDemo {

    @MyBook(name="<<学习每一天11>>",authors = {"44","miao"},price = 14)
    private AnnotationDemo(){

    }
    @MyBook(name="<<学习每一天22>>",authors = {"44","miao"},price = 14)
    public static void main(String[] args) {

        @MyBook(name="<<学习每一天>>",authors = {"44","miao"},price = 14)
        int age = 12;
    }
}
