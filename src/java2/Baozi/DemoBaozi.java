package java2.Baozi;

public class DemoBaozi {
    public static void main(String[] args) {
        Baozi baozi = new Baozi();

        new BaoziPu(baozi).start();

        new Chihuo(baozi).start();
    }
}
