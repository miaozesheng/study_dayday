package test.static_test.singleinstance;

/**
 * @author Administrator 懒汉式单例对象
 * 需要的时候才去加载
 */
public class SingleInstanceTwo {
    /**
     * 提供一个私有构造器
     */
    private SingleInstanceTwo(){}
    /**
     * 使用一个static修饰的实例
     */
    public static SingleInstanceTwo instanceTwo; //null

    /**
     * 定义一个方法，让其他地方可以调用获取一个对象,如果该单例存在，那么返回，如果不存在，创建一个返回。
     */
    public static SingleInstanceTwo getInstance(){
        if(instanceTwo==null){
            instanceTwo = new SingleInstanceTwo();
        }
        return instanceTwo;
    }
}
