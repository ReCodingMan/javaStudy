package cc1021.Animal;

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
        NUM = 20;
    }

    public Cat() {
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("猫吃鱼");
    }
}
