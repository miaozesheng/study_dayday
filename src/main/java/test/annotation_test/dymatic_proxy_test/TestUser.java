package test.annotation_test.dymatic_proxy_test;

/**
 * description
 *
 * @author miaozesheng 2022/03/22 22:45
 */
public class TestUser {
    public static void main(String[] args) {

//        UserService userService = new UserServiceImpl();
//        userService.login("admin","123456");
//        userService.deleteUser(6L);
//        userService.selectUsers();;

        // 使用代理实现的话 我们需要把业务对象直接做成一个代理对象返回,代理对象的类型也是UserService类型
        UserService userService = ProxyUtils.getProxy(new UserServiceImpl());
        userService.login("admin","123456");
        userService.deleteUser(6L);
        userService.selectUsers();;
    }
}
