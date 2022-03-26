package test.annotation_test;

/**
 * description
 *
 * @author miaozesheng 2022/03/22 22:16
 */
@Desk(value = "注解解析测试在类上",price = 299.9,authors = {"miaozesheng","liu"})
public class BookStore {

    @Desk(value = "测试注解解析在成员方法上",price = 99.9,authors = "miao")
    private void test(){

    }
}
