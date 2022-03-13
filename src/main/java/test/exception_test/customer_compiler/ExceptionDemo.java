package test.exception_test.customer_compiler;

/**
 * description
 *
 * @author miaozesheng 2022/03/13 12:14
 */
public class ExceptionDemo {
    public static void main(String[] args) {

        try {
            checkAge(1000);
        } catch (CustomerCompilerException e) {
            e.printStackTrace();
        }
    }
    public static void checkAge(int age) throws CustomerCompilerException{
        if(age<0 || age>120){
            // 抛出去一个异常对象给调用者
            // throws是申明在方法上边的 throw是在方法内部创建一个异常对象,并从词典抛出
            throw new CustomerCompilerException(age+"年龄好像也不对劲啊");
        }else{
            System.out.println("推荐商品给他!!");
        }
    }
}
