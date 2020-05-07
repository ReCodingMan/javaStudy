package java2.FileUpload;

import java.io.*;
import java.net.Socket;

/**
 *  文件上传案例的客户端：读取本地文件，上传到服务器，读取服务器回写的数据
 *
 *  明确：
 *      数据源：
 *      目的地：服务器
 *
 *  实现步骤：
 *      1、创建一个本地字节输入流 FileInputStream 对象，构造方法中绑定要读取的数据源
 *      2、创建一个客户端 Socket 对象，在构造方法中绑定服务器的 IP 地址和端口号
 *      3、使用 Socket 中的方法 getOutputStream，获取网络字节输出流 OutputStream 对象
 *      4、使用本地字节输入流 FileInputStream 对象中的方法 read，读取本地文件
 *      5、使用网络字节输出流 OutputStream 对象中的 write 方法，把读取到的文件上传到服务器
 *      6、使用 Socket 中的方法 getInputStream，获取网络字节输入流 InputStream 对象
 *      7、使用网络字节输入流 InputStream 对象中的方法 read 读取服务器回写的数据
 *      8、释放资源（FileInputStream, Socket）
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
        //1、创建一个本地字节输入流 FileInputStream 对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("/Users/chengcheng/Desktop/test/trailer.mp4");

        //2、创建一个客户端 Socket 对象，在构造方法中绑定服务器的 IP 地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);

        //3、使用 Socket 中的方法 getOutputStream，获取网络字节输出流 OutputStream 对象
        OutputStream os = socket.getOutputStream();

        //4、使用本地字节输入流 FileInputStream 对象中的方法 read，读取本地文件
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            //5、使用网络字节输出流 OutputStream 对象中的 write 方法，把读取到的文件上传到服务器
            os.write(bytes, 0, len);
        }

        /**
         * 解决：上传完文件，给服务器一个结束标记
         * void shutdownOutput() 禁用此套接字的输出流
         * 对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列
         */
        socket.shutdownOutput();

        //6、使用 Socket 中的方法 getInputStream，获取网络字节输入流 InputStream 对象
        InputStream is = socket.getInputStream();

        //7、使用网络字节输入流 InputStream 对象中的方法 read 读取服务器回写的数据
        while ((len = is.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, len));
        }

        //8、释放资源（FileInputStream, Socket）
        fis.close();
        socket.close();
    }


}
