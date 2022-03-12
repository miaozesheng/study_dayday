package test.polymorphic_test;

public class Mouse implements USB{

    @Override
    public void connect() {
        System.out.println("鼠标连接了okok");
    }

    // 鼠标类中的独有操作
    public void click(){
        System.out.println("我是鼠标，我要开始敲击了！！");
    }
    @Override
    public void unConnect() {
        System.out.println("鼠标断开连接了");
    }
}
