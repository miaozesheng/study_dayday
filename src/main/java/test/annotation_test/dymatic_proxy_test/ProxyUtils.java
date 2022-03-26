package test.annotation_test.dymatic_proxy_test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * description 代理工具类 这个类给我们产生代理
 *  生产业务对象的代理对象
 *
 * @author miaozesheng 2022/03/22 23:04
 */
public class ProxyUtils {
    /*
     public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
         loader 类加载器对象 负责加载代理对象到内存中使用
         interfaces 获取被代理对象实现的全部接口 比如我们这里UserServiceImpl就实现了UserService接口 要为全部接口的全部方法进行代理
         h   代理的核心处理逻辑   InvocationHandler是一个接口,我们要使用使用匿名内部类的方式使用
     */

    public static UserService getProxy(UserServiceImpl obj) {
        // UserServiceImpl obj 这里的obj就是我们的业务对象

        // 这里进行强转的原因是,系统不知道我们代理的是哪个业务对象,所以它底层实现返回一个object类型的对象,适配所有方法 我们明确自己的业务对象,进行强转使用
        return (UserService) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*
                Object proxy,  代理对象本身,一般不管
                Method method,  正在被代理的方法,如login,selectUser,delete
                Object[] args 被代理方法应该传入的参数 如delete传入Long类型的id
                 */

                long startTime = System.currentTimeMillis();
                // 真正业务结果的执行 并返回结果
                Object result = method.invoke(obj,args);
                long endTime = System.currentTimeMillis();
                System.out.println(method.getName()+"方法耗时为:=============>"+(endTime-startTime)/1000+"秒");
                return result;
            }
        });
    }

    public static <T> T getProxy2(T obj) {
        // UserServiceImpl obj 这里的obj就是我们的业务对象

        // 这里进行强转的原因是,系统不知道我们代理的是哪个业务对象,所以它底层实现返回一个object类型的对象,适配所有方法 我们明确自己的业务对象,进行强转使用
        return  (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*
                Object proxy,  代理对象本身,一般不管
                Method method,  正在被代理的方法,如login,selectUser,delete
                Object[] args 被代理方法应该传入的参数 如delete传入Long类型的id
                 */

                long startTime = System.currentTimeMillis();
                // 真正业务结果的执行 并返回结果
                Object result = method.invoke(obj,args);
                long endTime = System.currentTimeMillis();
                System.out.println(method.getName()+"方法耗时为:=============>"+(endTime-startTime)/1000+"秒");
                return result;
            }
        });
    }
}
