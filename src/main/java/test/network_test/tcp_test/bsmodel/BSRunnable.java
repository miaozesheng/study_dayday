package test.network_test.tcp_test.bsmodel;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * description
 *
 * @author miaozesheng 2022/03/20 20:19
 */
public class BSRunnable implements Runnable{

    private Socket socket;
    public BSRunnable(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            //浏览器,已经与本线程建立了Socket管道
            // 响应消息给浏览器显示
            PrintStream ps = new PrintStream(socket.getOutputStream());
            // 必须响应http协议格式数据,不然浏览器不认识
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();//必须发送一个开航 才可以响应数据回去给浏览器
            ps.println("<span style='color:red;font-size=90px'>我们返回的数据在这里了!!!!!!!!</span>");
            ps.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
