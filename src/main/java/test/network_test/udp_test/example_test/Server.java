package test.network_test.udp_test.example_test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * description 服务端(数据接收端) 测试的时候先启用服务端
 *
 * @author miaozesheng 2022/03/20 12:54
 */
public class Server {
    public static void main(String[] args) throws Exception{

        System.out.println("==========服务端启动=========");
        // 1.创建接收端对象
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        // 2.创建一个数据包接收封装数据
        byte[] buffer = new byte[1024*64];
        DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length);
        while (true) {
            // 3.等待接收数据
            datagramSocket.receive(datagramPacket);
            // 4.取出数据看看
            int len = datagramPacket.getLength();
            String rs = new String(buffer,0,len);
            System.out.println("收到了来自IP地址:"+datagramPacket.getAddress()+"=====对方端口为:"+datagramPacket.getPort()+"的消息为:"+rs);
        }

    }
}
