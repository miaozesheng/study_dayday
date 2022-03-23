package test.simple_design_model.decorator;

/**
 * description
 *
 * @author miaozesheng 2022/03/24 00:32
 */
public class MyFileInputStream extends MyInputStream{

    @Override
    public int read() {
        System.out.println("低性能读取字节a");
        return 97;
    }

    @Override
    public int read(byte[] buffer) {
        buffer [0] =97;
        buffer [1] =98;
        buffer [2] =99;
        System.out.println("低性能读取一个字节数据"+buffer);
        return 3;
    }
}
