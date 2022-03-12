package test.polymorphic_test;

public class Keyboard implements USB{
    @Override
    public void connect() {
        System.out.println("键盘连接了 oko");
    }

//    键盘类中的独有操作
    public void input(){
        System.out.println("我是键盘，我要打字了！！！！！");
    }
    @Override
    public void unConnect() {
        System.out.println("键盘断开连接了okok");
    }
}
