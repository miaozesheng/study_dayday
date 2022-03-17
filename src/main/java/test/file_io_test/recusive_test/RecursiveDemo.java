package test.file_io_test.recusive_test;

/**
 * description 递归说明
 *
 * @author miaozesheng 2022/03/14 22:04
 */
public class RecursiveDemo {
    /**
     *
     * 直接递归: 自己调用自己
     * 间接递归: 自己调用别人,别人调回自己
     */
    public static void main(String[] args) {
        System.out.println(f(6));
    }
    public static int f(int n ){
        if(n==1){
            return 1;
        }else{
            return f(n-1)*n;
        }
    }
    /**
     * 猴子吃桃问题 第一天拆下若干桃子,吃了一半,又多吃了一个
     * 第二天吃了第一天剩余桃子的一半,有多吃了一个,
     * 第三天同样如此,直到第十天,只有一个桃子了,问第一天拆了多少个桃子
     * 解析:
     * f(x)-f(x)/2-1=f(x+1)
     * f(x)=2f(x+1)+2
     *
     * f(10)=1
     */
    public static int f1(int n){
        if (n == 10) {
            return 1;
        } else {
            return 2 * f1(n + 1) + 2;
        }
    }
}
