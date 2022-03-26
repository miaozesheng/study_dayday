package test.junit_test;

import org.junit.*;

/**
 * description junitDemo的测试类
 *
 * @author miaozesheng 2022/03/20 21:02
 */
public class TestJunitDemo {

    /**
     * 测试方法:
     * 注意点:
     *  1.必须是公开的,无参数,无返回值的方法
     *  2.测试方法必须使用@Test注解标记
     *
     * 常用注解: 开始执行的方法,初始化资源 测试方法执行完之后执行的是为了释放资源
     * @Before 修饰实例方法 在方法执行之前执行
     * @After 修饰实例方法 在方法执行之后执行
     * @BeforeClass 修饰静态方法 在方法执行之前执行
     * @AfterClass 修饰静态方法 在方法执行之后执行
     */

    @Before
    public void before(){
        System.out.println("before执行一次");
    }

    @After
    public void after(){
        System.out.println("");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeclass执行一次");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterclass执行一次");
    }

    @Test
    public void testLoginName(){
        JUnitDemo jUnitDemo = new JUnitDemo();
        String rs = jUnitDemo.loginName("admin2","123456");
        // 进行预期结果的正确性测试
        Assert.assertEquals("业务出现问题了!","登录成功",rs);
    }

    @Test
    public void testSelectNames(){
        JUnitDemo jUnitDemo = new JUnitDemo();
        jUnitDemo.selectNames();
    }

}
