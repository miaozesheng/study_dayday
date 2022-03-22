package test.annotation_test.dymatic_proxy_test;

/**
 * description
 *
 * @author miaozesheng 2022/03/22 22:45
 */
public class UserServiceImpl implements UserService{

    @Override
    public String login(String login, String password) {
        long endTime= System.currentTimeMillis();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if("admin".equals(login) && "123456".equals(password)){
                return "登录成功!";
            }else{
                return "账户M码有问题!";
            }
        } finally {
            long startTime = System.currentTimeMillis();
            System.out.println("login方法耗时为=========>"+(startTime-endTime)/1000+"秒");
        }
    }

    @Override
    public void selectUsers() {
        long startTime  = System.currentTimeMillis();
        try {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("查询到了所有的数据");
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("select方法耗时为=========>"+(startTime-endTime)/1000+"秒");
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        long startTime  = System.currentTimeMillis();
        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(6==id ){
                return true;
            }else{
                return false;
            }
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("delete方法耗时为=========>"+(startTime-endTime)/1000+"秒");
        }
    }
}
