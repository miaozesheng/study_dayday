package test.stream_test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 */
public class StreamTest {
    /**
     * 关于stream流的说明： 流只是对于数据做处理,但是不会去修改数据.处理是指过滤取值等操作,但是不会在流中直接去修改数据
     * 另外流只能操作一次.我们可以理解为流就是水龙头里边的水,一次用完了后边只能重新去接再使用,使用过的水是不能再被使用的
     *  1.流的创建方式
     *  2.流的常见方法
     *  3.流的终结方法
     * 666
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张三丰");
        list.add("张真人");
        testStream2(list);
    }

    /**
     * list set map array变成stream流
     */
    public static void testStream1(){
        Collection<String> list = new ArrayList<>();
        Stream<String>  listStream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> setStream = set.stream();

        Map<Integer,String> map = new HashMap<>();
        Stream<Integer> keyStream = map.keySet().stream();
        Stream<String> valuesStream = map.values().stream();
        Stream<Map.Entry<Integer,String>> mapStream = map.entrySet().stream();

        String[] str = new String[5];
        Stream<String> stringStream = Arrays.stream(str);
        Stream<String> strStream = Stream.of(str);

    }

    /**
     * 流的具体实现及方法剖析
     */
    public static void testStream2(List<String> list){
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        });
        list.stream().filter(s -> s.startsWith("张"));

        // map是一个加工方法,可以将一种类型映射为另外一种类型
        List<Person> collect = list.stream().map(s -> new Person(s)).collect(Collectors.toList());

        list.stream().map(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return s.toLowerCase();
            }
        });
        list.stream().map(String::toLowerCase);

        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        list.stream().forEach(System.out::println);

        list.stream().count();

        list.stream().skip(3);

        list.stream().collect(Collectors.toList());

        list.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.hashCode()-o2.hashCode();
            }
        });

        list.stream().max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0)-o2.charAt(0);
            }
        });
    }
    public static void testStream3(){

    }
}
