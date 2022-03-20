package test.network.udp_test.multicase_test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * description 组播测试
 *
 * @author miaozesheng 2022/03/20 12:54
 */
public class Server {
    public static void main(String[] args) throws Exception{

        System.out.println("==========服务端启动=========");
        // 1.创建接收端对象
        MulticastSocket multicastSocket = new MulticastSocket(9999);
        // 把当前接收端加入到一个组播组中,绑定对应组播消息的组播ip
        multicastSocket.joinGroup(InetAddress.getByName("224.0.1.1"));
        // 2.创建一个数据包接收封装数据
        byte[] buffer = new byte[1024*64];
        DatagramPacket datagramPacket = new DatagramPacket(buffer,buffer.length);
        while (true) {
            // 3.等待接收数据
            multicastSocket.receive(datagramPacket);
            // 4.取出数据看看
            int len = datagramPacket.getLength();
            String rs = new String(buffer,0,len);
            System.out.println("收到了来自IP地址:"+datagramPacket.getAddress()+"=====对方端口为:"+datagramPacket.getPort()+"的消息为:"+rs);
        }

    }
}
