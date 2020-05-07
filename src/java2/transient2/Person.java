package java2.transient2;

import java.io.Serializable;

/**
 *  序列化和反序列化的时候，会抛出 NotSerializableException 没有序列化异常
 *  类通过实现 java.io.Serializable 接口以启动其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化
 *
 *  Serializable 接口也叫标记型接口
 *      要进行序列化和反序列化的类必须实现 serializable 接口，就会给类添加一个标记
 *      当我们进行序列化和反序列化的时候，就会检测类上是否有这个标记
 *          有：就可以
 *          没有：就会抛出 NotSerializableException 异常
 *
 *  去市场买肉-->肉上有一个蓝色章（检测合格）-->放心购买-->买回来怎么吃随意
 *
 *  static关键字：静态关键字
 *      静态优先于非静态加载到内存中（静态优先于对象进入到内存中）
 *      被 static 修饰的成员变量不能被序列化的，序列化的都是对象
 *
 *  transient关键字：瞬态关键字
 *      被 transient 修饰成员变量，不能被序列化
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    public String name;
    //private static int age;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
