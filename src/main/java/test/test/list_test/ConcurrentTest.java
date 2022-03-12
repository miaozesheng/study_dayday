package test.test.list_test;


import java.util.*;
import java.util.function.Consumer;

public class ConcurrentTest {
    public static void main(String[] args) {
       // 给定一个list集合，用以测试
        List<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.add("2222");
        list.add("3333");
        list.add("4444");
        // 主要测试集合并发删除异常
        // 出现并发修改异常的原因是，删除一个元素后，删除掉的元素后一位补了上来，然后指针又向后移了一位，导致一个位置的元素没有被遍历到
        testOne(list);
        //testTwo(list);
        //testThree(list);
//        testFour(list);
    }

    public static void  testOne(List<String> list){
        // 使用普通for循环进行删除
//        for(int i = 0;i<list.size();i++){
//            if("2222".equals(list.get(i))){
//                list.remove(list.get(i));
//            }
//        }
        System.out.println(list);
        // 解决方案 使用倒序的方式，每次删除之后后边的元素会补上来，但是后边的元素已经被遍历过了
//        for(int i = list.size()-1;i>=0;i--){
//            if("2222".equals(list.get(i))){
//                list.remove(list.get(i));
//            }
//        }
//        System.out.println(list);
        // 使用正序的也行，但是每次删除之后，index都要向前移一下，可以遍历到那个补位上来的元素
        for (int i = 0; i < list.size(); i++) {
            if ("2222".equals(list.get(i))) {
                list.remove(list.get(i));
                i--;
            }
        }
        System.out.println(list);
    }

    public static void  testTwo(List<String> list){
        // 使用增强for循环进行删除
        for(String s : list){
            if("2222".equals(s)){
                list.remove(s);
            }
        }
        System.out.println(list);

    }

    public static void  testThree(List<String> list){
        // 使用lambda表达式进行删除
        list.forEach(s -> {
            if("2222".equals(s)){
                list.remove(s);
            }
        });

    }

    public static void  testFour(List<String> list){
        // 使用迭代器进行删除
//        Iterator<String> iterator = list.iterator();
//        while(iterator.hasNext()){
//            String s = iterator.next();
//            if("2222".equals(s)){
//                list.remove(s);
//            }
//        }

        // 解决方案 我们使用迭代进行删除时，不能使用list的remove方法，而要使用迭代器自带的remove方法即可


        // 第一种复杂形式
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            if("2222".equals(s)){
                iterator.remove();
            }
        }
        System.out.println(list);
        // 第二种简单形式
        list.removeIf("2222"::equals);
        Set<String> set = new HashSet<>();
    }

}
