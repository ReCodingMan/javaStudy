package cc1021.fanshe;

public class Student {
    //成员变量，一个私有，一个默认，一个公共
    private String name;
    int age;
    public String address;

    //构造方法，一个私有，一个默认，两个公共
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Student(String name) {
        this.name = name;
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student() {
    }

    //成员方法，一个私有，4个公共
    private void function(){
        System.out.println("function");
    }

    public void method1(){
        System.out.println("method");
    }

    public void method2(String s){
        System.out.println("method " + s);
    }

    public String method3(String s, int i){
        return s + "," + i;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
