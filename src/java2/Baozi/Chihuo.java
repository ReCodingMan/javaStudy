package java2.Baozi;

/**
 * 消费者（吃货）类：是一个线程类，可以继承 Thread
 * 设置线程任务（run）：吃包子
 * 对包子的状态进行判断
 *      false：没有包子
 *              吃货调用wait方法进入等待状态
 *      true：有包子
 *              吃货吃包子
 *              吃完包子修改包子状态false
 *              吃货唤醒包子铺线程，生产包子
 */
public class Chihuo extends Thread{

    //1、需要在成员变量创建一个包子变量
    private Baozi bz;

    //2、使用带参数的构造方法，为这个包子变量赋值
    public Chihuo(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        //使用死循环，一直吃包子
        while (true) {
            //必须同时同步技术保证只有一个线程在执行
            synchronized (bz) {
                //对包子状态进行判断
                if (bz.flag == false){
                    //吃货调用wait方法进行等待
                    try {
                        bz.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                //被唤醒之后，开始吃包子
                System.out.println("吃货正在吃："+bz.pi+bz.xian+"包子");
                //吃完包子，修改状态false
                bz.flag = false;
                //吃货唤醒包子铺线程，生产包子
                bz.notify();
                System.out.println("吃货已经把："+bz.pi+bz.xian+"包子吃完了，包子铺开始生产包子");
                System.out.println("----------------------------------------------");
            }
        }
    }
}
