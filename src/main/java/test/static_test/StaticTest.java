package test.static_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator 测试静态代码块
 * 模拟一个斗地主之前，使用静态资源加载一副牌的场景
 */
public class StaticTest {


    /**
     * 先创建一个list，用以接受所有的牌,这个list也需要使用static修饰，才能被静态代码块使用
     */
    public static List<String> list = new ArrayList<>();

    static {
        String [] colors = {"红桃","黑桃","红方板","黑梅子"};
        String [] size = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for(int i = 0 ; i < size.length;i++){
            for(int j = 0;j<colors.length;j++){
                list.add(colors[j]+size[i]);
            }
        }
        // 添加大小王
        list.add("大王");
        list.add("小王");
    }

    public static final String name;

    public static void main(String[] args) {
        System.out.println("牌是："+list);
    }

    static {
        name = "111";
    }
}


