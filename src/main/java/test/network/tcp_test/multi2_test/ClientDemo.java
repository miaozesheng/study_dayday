package test.network.tcp_test.multi2_test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * description tcp客户端开发,多发多收 这里面要求实现一个服务端可以接受多个客户端的消息
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
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("说出你想说的话:");
                String msg = sc.nextLine();
                ps.println(msg);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
