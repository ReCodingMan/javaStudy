package cc1021.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientDemo02 {

    public static void main(String[] args) throws IOException {

        //1、创建一个Socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);

        //2、创建一个输出流
        OutputStream os = socket.getOutputStream();

        //3、文件流

    }
}
