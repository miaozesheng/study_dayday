package test.simple_design_model.factory;

/**
 * description 比如在实际生活中,我们想要一台电脑,我们不会自己做 而是让工厂做好之后,我们直接买就好了
 *
 * @author miaozesheng 2022/03/24 00:14
 */
public class FactoryDemo {
    public static void main(String[] args) {
        // 原本的方式
//        Computer computer = new Mac();
//        computer.setName("苹果");
//        computer.setPrice(19999);
//        Computer computer1 = new Windows10();
//        computer1.setName("windows");
//        computer1.setPrice(100);

        //工厂方法的模式
        Computer c = FactoryPattern.createComputer("mac");
        System.out.println(c);
        c.start();
    }

}
