package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test06 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //获取Class对象
        Class c1 = Class.forName("reflection.User");

        //构造一个对象
        User user = (User) c1.newInstance(); //调用了无参构造器
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(int.class, String.class, int.class);
        User user2 = (User) constructor.newInstance(001, "cc", 20);
        System.out.println(user2);

        //通过反射调用方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user, "cc2");
        System.out.println(user);

        //通过反射操作属性
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user, "cc3");//不能直接操作私有属性，需要关闭程序的安全校验，属性或者方法的 setAccessible
        System.out.println(user.getName());
    }
}
