public class Lambda {

    public static void main(String[] args) {
        new Thread( () -> {
            System.out.println("多线程启动了");
        }).start();
    }

}
