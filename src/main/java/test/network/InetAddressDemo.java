package test.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * description InetAddress的常用方法使用
 *
 * @author miaozesheng 2022/03/20 12:26
 */
public class InetAddressDemo {
    public static void main(String[] args) throws Exception {

        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());
        /*
        192.168.31.246
        miaozesengdeMBP
        36.152.44.95
        www.baidu.com
         */
        System.out.println(ip2.isReachable(5000)); // 判断是否可以ping通
    }
}
