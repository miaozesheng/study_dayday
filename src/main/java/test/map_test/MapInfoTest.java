package test.map_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapInfoTest {
    static String  resultArea = "";
    static Integer resultNumber  = 0;
    public static void main(String[] args) {

         // 首先有10个地区

        String [] areas = {"北京","上海","深圳","广州","天津","西安","重庆","成都","内蒙","榆林"};
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
         // 其次要有1000个人选择想去的地区
        for(int i = 0 ; i<1000;i++){

            if(i==999){
                stringBuffer.append(areas[random.nextInt(areas.length)]);
                continue;
            }
            stringBuffer.append(areas[random.nextInt(areas.length)]);
            stringBuffer.append(",");
        }
        System.out.println(stringBuffer);
        String resultString = stringBuffer.toString();
        String [] result = resultString.split(",");
        Map<String,Integer> resultMap = new HashMap<>();
        for (String s : result) {

            if(resultMap.containsKey(s)){
                resultMap.put(s,resultMap.get(s)+1);
            }else{
                resultMap.put(s,1);
            }
        }
//        最后遍历map

        resultMap.forEach((k,v)-> {
            if(resultArea.equals("") && resultNumber==0){
                resultArea = k;
                resultNumber = v;
            }
            if(v>resultNumber){
                resultNumber = v;
                resultArea = k ;
            }
            System.out.println(k+"-------->"+v);
        });
        System.out.println("最受欢迎的地区为："+resultArea+"   选择人数为： "+resultNumber);
    }
}
