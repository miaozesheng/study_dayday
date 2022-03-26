package test.simple_design_model.factory;

/**
 * description
 *
 * @author miaozesheng 2022/03/24 00:14
 */
public class Computer {

    private String name;
    private double price;

    public Computer() {
    }

    public String getName() {
        return name;
    }

    public void start(){
        System.out.println("电脑启动了!!!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
