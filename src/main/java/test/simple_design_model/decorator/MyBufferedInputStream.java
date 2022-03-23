package test.simple_design_model.decorator;

/**
 * description 装饰类 扩展原始类的功能,把原始类拿进来 MyFileInputStream
 *
 * @author miaozesheng 2022/03/24 00:34
 */
public class MyBufferedInputStream extends MyInputStream{

    private MyInputStream is;
    public MyBufferedInputStream(MyInputStream inputStream ){
        this.is = inputStream;
    }

    @Override
    public int read() {
        System.out.println("提供了8kb的缓冲区,提高性能");
        return is.read();
    }

    @Override
    public int read(byte[] buffer) {
        System.out.println("提供了8kb的缓冲区,提高性能");
        return is.read(buffer);
    }
}
