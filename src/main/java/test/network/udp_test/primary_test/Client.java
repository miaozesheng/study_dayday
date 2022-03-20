package test.network.udp_test.primary_test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * description 发送端 一发一收
 *
 * @author miaozesheng 2022/03/20 12:53
 */
public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("==========客户端启动=========");

        // 1.创建发送端对象 自己有端口号,构造器里边不需要给端口号
        DatagramSocket socket = new DatagramSocket();
        // 2.创建一个数据包对象封装数据
        /*
          byte buf[],                封装要传输的数据 需要转成byte数组
          int length,                传输数据的长度
          InetAddress address,       服务端(数据接收端)的ip地址
          int port                   服务端(数据接收端)端口号
         */
        byte[] bytes = "我是一个爱学习的娃!!".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket("我是一个爱学习的娃!!".getBytes(StandardCharsets.UTF_8), bytes.length, InetAddress.getLocalHost(), 8888);

        // 3 发送数据
        socket.send(packet);

        socket.close();
    }
}
