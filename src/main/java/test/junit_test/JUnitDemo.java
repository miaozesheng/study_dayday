package test.junit_test;

/**
 * description 单元测试
 *
 * @author miaozesheng 2022/03/20 20:48
 */
public class JUnitDemo {

    public String loginName(String loginName,String password){
        if("admin".equals(loginName) && "123456".equals(password)){
            return "登录成功";
        }else{
            return "登录失败";
        }
    }

    public void selectNames(){
        System.out.println(10/0);
        System.out.println("查询用户数据成功!!");
    }

}
