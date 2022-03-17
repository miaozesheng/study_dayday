package test.test.list_test;

import java.util.*;

public class DouDIZhu {

    // 首先定义一个静态的list，来存放所有的牌
    public static List<Card> allCard = new ArrayList<>();


    static{
        // 如果要给一些默认初始值，我们选择在static静态代码块中实现
        // 确认类型，确认个数，我们使用数组 花色和牌的大小
        String [] size = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String [] color = {"♣","♥","♠","方块"};

        int power = 0;
        for (String s : size) {
            power++;
            for (String c : color) {
                allCard.add(new Card(s,c,power));
            }
        }
        ++power;
        Card card2 = new Card("","小王",power);
        ++power;
        Card card = new Card("","大王",power);
        Collections.addAll(allCard,card,card2);
        System.out.println(allCard);

    }

    public static void main(String[] args) {
        Collections.shuffle(allCard);
        System.out.println(allCard);
        // 要玩斗地主，要有三个人，我们这里看做三个集合，另外还有三张剩余地主的牌，也要看做一个集合
        List<Card> miaozesheng = new ArrayList<>();
        List<Card> miaozewang = new ArrayList<>();
        List<Card> chenyu = new ArrayList<>();
        List<Card> bottomPapper = new ArrayList<>();
        for(int i = 0;i<allCard.size()-3;i++){
            Card card = allCard.get(i);
            if(i%3 == 0){
                miaozesheng.add(card);
            }
            if(i%3 ==1){
                miaozewang.add(card);
            }
            if(i%3==2){
                chenyu.add(card);
            }
        }
        //最后将三张底牌给到某一个人
        bottomPapper = allCard.subList(allCard.size()-3,allCard.size());
        // 将每个人的手牌排序
        papperSort(miaozesheng);
        papperSort(miaozewang);
        papperSort(chenyu);
        System.out.println(miaozesheng);
        System.out.println(miaozewang);
        System.out.println(chenyu);


    }
    public static void papperSort(List<? extends Card> list){
        // 这里需要重写牌的排序方法，那么就必须给一个规则，我们这里给牌类里边添加一个牌的大小

//        Collections.sort(list, new Comparator<Card>() {
//            @Override
//            public int compare(Card o1, Card o2) {
//                return o1.getPower()-o2.getPower();
//            }
//        });

        Collections.sort(list,(o1, o2) -> o1.getPower()-o2.getPower());
    }

}
