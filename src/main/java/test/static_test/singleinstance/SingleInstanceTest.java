package test.static_test.singleinstance;

/**
 * @author Administrator 单例对象的测试
 */
public class SingleInstanceTest {
    public static void main(String[] args) {
        SingleInstance instance = SingleInstance.instance;
        SingleInstance instance2 = SingleInstance.instance;
        SingleInstance instance3 = SingleInstance.instance;

        // 打印出几个对象的地址，就知道是不是单例的对象了
        System.out.println(instance); //test.statictest.singleinstance.SingleInstance@4eec7777
        System.out.println(instance2); //test.statictest.singleinstance.SingleInstance@4eec7777
        System.out.println(instance3); //test.statictest.singleinstance.SingleInstance@4eec7777

    }
}
