package test.simple_design_model.factory;

/**
 * description 电脑工厂,创建电脑对象,并且返回
 *
 * @author miaozesheng 2022/03/24 00:20
 */
public class FactoryPattern {
    
    public static Computer createComputer(String info){
        Computer c;
        switch (info){
            case "windows":
                c = new Windows10();
                c.setName("华为");
                c.setPrice(100);
                break;
            case "mac":
                c = new Mac();
                c.setName("macbook");
                c.setPrice(1000);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + info);
        }
        
        return c;
    }
}
