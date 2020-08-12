package reflection;

public class Test04 {

    static {
        System.out.println("main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        Son son = new Son();
//        main类被加载
//        父类被加载了
//        子类被加载

        //反射也会主动调用
        //Class.forName("reflection.Son");

        //不会产生类的引用
        //System.out.println(Son.b);

        //Son[] array = new Son[5];

        System.out.println(Son.M);
    }
}

class Father {
    static int b = 2;
    static {
        System.out.println("父类被加载了");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}
