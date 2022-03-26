package test.simple_design_model.decorator;

/**
 * description 共同父类
 *
 * @author miaozesheng 2022/03/24 00:31
 */
public abstract class MyInputStream {

    public abstract int read();

    public abstract int read(byte [] buffer);
}
