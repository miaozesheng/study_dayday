package test.polymorphic_test;

import java.security.Key;

public class Computer {
    private String name;

    public Computer(String name) {
        this.name = name;
    }

    // 电脑类中单独提供一个安装USB设备的入口
    public void installUSB(USB usb){
        // 这里我们会用到多态，因为usb设备可能是鼠标，也可能是键盘
        usb.connect();

        if(usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            mouse.click();
        }else if(usb instanceof Keyboard){
            Keyboard keyboard = (Keyboard) usb;
            keyboard.input();
        }
        usb.unConnect();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
