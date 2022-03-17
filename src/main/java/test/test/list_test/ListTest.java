package test.test.list_test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class ListTest {
    public static void main(String[] args) {
        testListOne();
    }


    public static void testListOne(){
        Collection<String> c = new ArrayList<>();
        c.add("1");
        c.add("12");
        c.add("13");
        c.add("14");
        // 使用lambda表达式的写法
        c.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
