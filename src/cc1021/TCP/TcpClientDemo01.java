package cc1021.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//客户端
public class TcpClientDemo01 {

    public static void main(String[] args) {

        Socket socket = null;
        OutputStream os = null;

        try {
            //1、要知道服务器的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //2、创建一个socket连接
            socket = new Socket(serverIP, port);
            //3、发送消息 IO流
            os = socket.getOutputStream();
            os.write("你好，欢迎学习Java".getBytes());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
