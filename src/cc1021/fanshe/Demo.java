package cc1021.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Class.forName("cc1021.fanshe.Student");

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field);
        }

        System.out.println("-----------");

        Field addressField = c.getField("address");

        Constructor<?> con = c.getConstructor();
        Object obj = con.newInstance();

        addressField.set(obj, "西安");

        System.out.println(obj);
    }
}
