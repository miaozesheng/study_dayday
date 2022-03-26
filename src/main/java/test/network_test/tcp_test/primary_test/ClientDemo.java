package test.network_test.tcp_test.primary_test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * description tcp客户端开发,一发一收
 *
 * @author miaozesheng 2022/03/20 18:07
 */
public class ClientDemo {
    public static void main(String[] args) {

        try {
            System.out.println("========客户端启动成功!!!========");
            // 创建socket客户端对象
            Socket socket = new Socket("127.0.0.1",7777);
            // 使用socket获取字节输出流
            OutputStream os = socket.getOutputStream();
            //低级的字节流包装成高级的打印流
            PrintStream ps = new PrintStream(os);
            ps.print("我是tcp客户端,我来发送消息了!!");
            ps.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
