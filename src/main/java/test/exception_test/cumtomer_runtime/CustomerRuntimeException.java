package test.exception_test.cumtomer_runtime;

import test.exception_test.customer_compiler.CustomerCompilerException;

/**
 * description 定义一个运行期异常
 *
 * @author miaozesheng 2022/03/13 12:23
 */
public class CustomerRuntimeException extends RuntimeException{
    public CustomerRuntimeException(){}

    public CustomerRuntimeException(String message){
        super(message);
    }
}
