package test.simple_design_model.decorator;

import org.junit.Test;

/**
 * description
 *
 * @author miaozesheng 2022/03/24 00:31
 */
public class DecoratorPattern {

    @Test
    public void test(){
        MyInputStream is = new MyBufferedInputStream(new MyFileInputStream());
        System.out.println(is.read());
        System.out.println(is.read(new byte[3]));
    }
}
