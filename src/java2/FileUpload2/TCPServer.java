package java2.FileUpload2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *  文件上传案例服务器端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写"上传成功"
 *
 *  明确：
 *      数据源：客户端上传的文件
 *      目的地：服务器的硬盘 /Users/chengcheng/Desktop/test/abc/test
 *
 *  实现步骤：
 *      1、创建一个服务器 ServerSocket 对象，和系统要指定的端口号
 *      2、使用 ServerSocket 对象中的方法 accept，获取到请求的客户端 Socket 对象
 *      3、使用 Socket 对象中的方法 getInputStream，获取到网络字节输入流 InputStream 对象
 *      4、判断 /Users/chengcheng/Desktop/test/abc/test 文件夹是否存在，不存在则创建
 *      5、创建一个本地字节输出流 FileOutputStream 对象，构造方法中绑定要输出的目的地
 *      6、使用网络字节输入流 InputStream 对象中的方法 read，读取客户端上传的文件
 *      7、使用本地字节输出流 FileOutputStream 对象中的方法 write，把读取到的文件保存到服务器的硬盘上
 *      8、使用 Socket 对象中的方法 getOutputStream，获取到网络字节输出流 OutputStream 对象
 *      9、使用网络字节输出流 OutputStream 对象中的方法 write，给客户端回写"上传成功"
 *      10、释放资源（FileOutputStream, Socket, ServerSocket）
 *
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建一个服务器 ServerSocket 对象，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);

        /**
         * 让服务器一直处于监听状态（死循环 accept 方法）
         * 有一个客户端上传文件，就保存一个文件
         */
        while (true) {

            //2、使用 ServerSocket 对象中的方法 accept，获取到请求的客户端 Socket 对象
            Socket socket = server.accept();

            /**
             * 使用多线程技术，提高程序的效率
             * 有一个客户端上传文件，就开启一个线程，完成文件的上传
             */

            new Thread(new Runnable() {
                //完成文件的上传
                @Override
                public void run() {
                    try {


                        //3、使用 Socket 对象中的方法 getInputStream，获取到网络字节输入流 InputStream 对象
                        InputStream is = socket.getInputStream();

                        //4、判断 /Users/chengcheng/Desktop/test/abc/test 文件夹是否存在，不存在则创建
                        File file = new File("/Users/chengcheng/Desktop/test/abc/test");
                        if(!file.exists()){
                            file.mkdirs();
                        }

                        /**
                         *  自定义一个文件的命名规则：防止同名的文件被覆盖
                         *  规则：域名 + 毫秒值 + 随机数
                         */
                        String fileName = "cc1021" + System.currentTimeMillis() + new Random().nextInt(9999999) + ".mp4";

                        //5、创建一个本地字节输出流 FileOutputStream 对象，构造方法中绑定要输出的目的地
                        FileOutputStream fos = new FileOutputStream(file + "//" + fileName);

                        //6、使用网络字节输入流 InputStream 对象中的方法 read，读取客户端上传的文件
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes)) != -1){
                            //7、使用本地字节输出流 FileOutputStream 对象中的方法 write，把读取到的文件保存到服务器的硬盘上
                            fos.write(bytes, 0, len);
                        }

                        //8、使用 Socket 对象中的方法 getOutputStream，获取到网络字节输出流 OutputStream 对象
                        //9、使用网络字节输出流 OutputStream 对象中的方法 write，给客户端回写"上传成功"
                        socket.getOutputStream().write("上传成功".getBytes());

                        //10、释放资源（FileOutputStream, Socket, ServerSocket）
                        fos.close();
                        socket.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }

        //关闭服务器
        //server.close();

    }
}
