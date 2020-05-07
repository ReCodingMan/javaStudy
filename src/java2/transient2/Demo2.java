package java2.transient2;

import java.io.*;

/**
 * java.io.ObjectInputStream extends InputStream
 * ObjectInputStream：对象的反序列化流
 * 作用：把文件中保存的对象，以流的方式读取出来使用
 *
 * 构造方法：
 *      ObjectInputStream(InputStream in) 创建从指定 InputStream 读取的 ObjectInputStream
 *      参数：
 *          InputStream in：字节输入流
 *
 * 特有的成员方法：
 *      Object readObject() 从 ObjectInputStream 读取对象
 *
 * 使用步骤：
 *      1、创建 ObjectInputStream 对象，构造方法中传递字节输入流
 *      2、使用 ObjectInputStream 对象中的方法 readObject 读取保存对象的文件
 *      3、释放资源
 *      4、使用读取出来的对象（打印）
 *
 */
public class Demo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1、创建 ObjectInputStream 对象，构造方法中传递字节输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/chengcheng/Desktop/test/abc/abc.txt"));
        //2、使用 ObjectInputStream 对象中的方法 readObject 读取保存对象的文件
        Object o = ois.readObject();
        //3、释放资源
        ois.close();
        //4、使用读取出来的对象（打印）
        System.out.println(o);

        Person p = (Person)o;
        System.out.println(p.getName() + p.getAge());
    }
}
