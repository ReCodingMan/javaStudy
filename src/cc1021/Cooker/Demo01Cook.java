package cc1021.Cooker;

public class Demo01Cook {

    public static void main(String[] args) {
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭了");
            }
        });
    }

    //定义一个方法
    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
