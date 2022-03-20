package test.network.udp_test.multicase_test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * description 组播测试
 *
 * @author miaozesheng 2022/03/20 12:53
 */
public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("==========客户端启动=========");

        // 1.创建发送端对象 自己有端口号,构造器里边不需要给端口号
        DatagramSocket socket = new DatagramSocket();
        // 2.创建一个数据包对象封装数据
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入:");
            String msg = sc.nextLine();
            if("exit".equals(msg)){
                System.out.println("下线成功!!");
                socket.close();
                break;
            }
            byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("224.0.1.1"), 9999);

            // 3 发送数据
            socket.send(packet);
        }

    }
}
