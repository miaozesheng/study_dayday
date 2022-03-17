package test.map_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    /**
     * map的特点 无序 无索引 不重复
     * set的特点 无序 无索引 不重复
     * map的key其实就是一个set，所以我们遍历的时候可以用set来获取map的键
     * @param args
     */
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"aaa");
        map.put(2,"aaabb");
        map.put(3,"aaacc");
        map.put(4,"aaadd");
        //testApi(map);
//        testTraversal(map);
//        testTraversal2(map);
        testTraversal3(map);
    }

    // 测试map的常用api
    public static<K,V> void testApi(Map<K,V> map){
        map.get(1);

        map.remove(1);

        map.containsKey(1);

        map.containsValue("aaa");

        map.clear();

        Set<Integer> keys =(Set<Integer>) map.keySet();


    }
//    测试map常用的遍历方式1
    public static<K,V> void testTraversal(Map<K,V> map){
        Set<K> ks = map.keySet();
        for(K k : ks){
            V value = map.get(k);
            System.out.println(value);
        }
    }
//    测试map常用的遍历方式2 将map转为一个set集合，这个set集合里边封装了一个完整的键值对对象entry
    // 我们需要注意的是，java认为map里边的一个键值对对象是不是一种数据类型的，所以使用foreach遍历的时候，必须给定一种类型 也就是map.entry才能进行遍历 这是一种set集合
    public static<K,V> void testTraversal2(Map<K,V> map){
        Set<Map.Entry<K,V>> entry = map.entrySet();
        for(Map.Entry<K,V> item : entry){
            System.out.println(item.getKey());
            System.out.println(item.getValue());
        }
    }
    //    测试map常用的遍历方式3 使用lambda表达式完成
    public static<K,V> void testTraversal3(Map<K,V> map){
        map.forEach((k,v)-> System.out.println(k+"--->"+v));
    }
}
