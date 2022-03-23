package test.simple_design_model.factory;

import java.awt.image.ColorModel;

/**
 * description
 *
 * @author miaozesheng 2022/03/24 00:15
 */
public class Mac extends Computer {

    @Override
    public void start() {
        super.start();
        System.out.println("Mac启动了!!");
    }
}
