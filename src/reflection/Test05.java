package reflection;

public class Test05 {

    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->拓展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取拓展类加载器的父类加载器-->根加载器（c/c++）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader1 = Class.forName("reflection.Test05").getClassLoader();
        System.out.println(classLoader1);

        //测试JDK内置的类是谁加载的
        ClassLoader classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        /*

/Users/chengcheng/Desktop/github/java/javaStudy/out/production/javaStudy:
/Users/chengcheng/Desktop/github/java/javaStudy/libs/druid-1.0.9.jar:
/Users/chengcheng/Desktop/github/java/javaStudy/libs/c3p0-0.9.5.2.jar:
/Users/chengcheng/Desktop/github/java/javaStudy/libs/commons-logging-1.2.jar:
/Users/chengcheng/Desktop/github/java/javaStudy/libs/spring-tx-5.1.10.RELEASE.jar:
/Users/chengcheng/Desktop/github/java/javaStudy/libs/spring-core-5.1.10.RELEASE.jar:
/Users/chengcheng/Desktop/github/java/javaStudy/libs/spring-jdbc-5.1.10.RELEASE.jar:
/Users/chengcheng/Desktop/github/java/javaStudy/libs/mchange-commons-java-0.2.12.jar:
/Users/chengcheng/Desktop/github/java/javaStudy/libs/mysql-connector-java-8.0.20.jar:
/Users/chengcheng/Desktop/github/java/javaStudy/libs/spring-beans-5.1.10.RELEASE.jar:
/Users/chengcheng/.m2/repository/junit/junit/4.12/junit-4.12.jar:
/Users/chengcheng/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar

         */
    }
}
