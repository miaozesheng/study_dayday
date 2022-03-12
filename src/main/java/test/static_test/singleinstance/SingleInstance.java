package test.static_test.singleinstance;

/**
 * @author Administrator 实现单例模式 饿汉式
 * 饿汉单例的意思就是，在类获取对象的时候，对象已经提前为你创建好了，这里我们就会使用static关键字
 */
public class SingleInstance {

    /**
     * 定义一个静态变量存储一个对象，属于类，类加载的时候跟着加载一次，保证始终只会有一个对象实例
     */
    public static SingleInstance instance = new SingleInstance();

    /**
     * 单例必须私有化构造器
     * 如果设置成public的，外部可以调用构造器，多次进行对象的创建，也就说不上是单例了，单例就是该对象只存在单个实例
     */
    private SingleInstance(){}
}
