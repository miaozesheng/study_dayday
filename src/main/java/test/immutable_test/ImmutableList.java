package test.immutable_test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 该test主要测试不可变集合的使用方法， 关键是of方法
 */
public class ImmutableList {
    public static void main(String[] args) {

        List<Integer> list = List.of(1,2,3,4);
        //list.add(5); //java.lang.UnsupportedOperationException

        /**
         * set集合使用不可变集合的时候，创建时候如果给了重复值就会报错
         * Set.of(1,1,2,3); java.lang.IllegalArgumentException
         */

        Set<Integer> set = Set.of(1,2,3);
        //set.add(4); //java.lang.UnsupportedOperationException

        Map<Integer,String> map = Map.of(1,"11",2,"22",3,"33");
        map.put(4,"333"); //java.lang.UnsupportedOperationException
    }
}
