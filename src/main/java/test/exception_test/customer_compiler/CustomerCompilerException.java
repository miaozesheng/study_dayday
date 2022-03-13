package test.exception_test.customer_compiler;

/**
 * description 自定义编译期异常
 *  1.继承exception类
 *  2.重写构造器
 *
 *  好处: 编译器就会报错提醒特别强烈,程序员会特殊处理 抛出或者捕获
 *
 * @author miaozesheng 2022/03/13 12:12
 */
public class CustomerCompilerException extends Exception{
    public CustomerCompilerException(){}

    public CustomerCompilerException(String message){
        super(message);
    }
}
