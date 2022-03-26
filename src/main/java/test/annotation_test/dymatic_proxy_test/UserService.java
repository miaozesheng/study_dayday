package test.annotation_test.dymatic_proxy_test;

/**
 * description
 *
 * @author miaozesheng 2022/03/22 22:45
 */
public interface UserService {

    String login(String login , String password);

    void selectUsers();

    boolean deleteUser(Long id);
}
