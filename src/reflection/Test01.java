package reflection;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();//向上转型
        System.out.println(person.name);


        //方式一：通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二：通过forname获得
        Class c2 = Class.forName("reflection.Student");
        System.out.println(c2.hashCode());

        //方式三：通过类名获得
        Class c3  = Student.class;
        System.out.println(c3.hashCode());

        //方式四：基本类属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);
    }
}

class Person{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student(){
        this.name = "学生";
    }
}

class Teacher extends Person {
    public Teacher(){
        this.name = "老师";
    }
}