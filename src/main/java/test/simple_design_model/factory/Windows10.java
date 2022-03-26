package test.simple_design_model.factory;

/**
 * description
 *
 * @author miaozesheng 2022/03/24 00:15
 */
public class Windows10  extends Computer{
    @Override
    public void start() {
        super.start();
        System.out.println("windows10启动了");
    }
}
