package test.polymorphic_test;

/**
 * usb作为接口
 */
public interface USB {
    // usb接口中有两个方法，一个是连接电脑，一个是断开连接

    void connect();

    void unConnect();
}
