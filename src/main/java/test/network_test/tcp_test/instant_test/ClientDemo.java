package test.network_test.tcp_test.instant_test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * description 即时通信
 * 1.客户端发送消息 客户端随时都可能接受消息 所以这里除了发送消息的线程,还要创建一个接收消息的线程
 *
 * @author miaozesheng 2022/03/20 18:07
 */
public class ClientDemo {
    public static void main(String[] args) {

        try {
            System.out.println("========客户端启动成功!!!========");
            // 创建socket客户端对象
            Socket socket = new Socket("127.0.0.1",6666);

            //创建一个接收消息的线程
            new ClientReaderThread(socket).start();

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
// 客户端读消息线程
class ClientReaderThread extends Thread{
    private Socket socket;

    public ClientReaderThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            InputStream is = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String msg;
            while((msg = bufferedReader.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress()+"发来了===========>"+msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
