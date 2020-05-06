package cc1021.Animal;

public class Animal {
    private String name;
    private int age;
    protected int NUM = 10;


    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void eat(){
        System.out.println("动物吃东西");
    }
}
