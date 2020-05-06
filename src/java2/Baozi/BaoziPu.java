package java2.Baozi;

/**
 * 生产者（包子铺）类：是一个线程类，可以继承 Thread
 * 设置线程任务（run）：生产包子
 * 对包子的状态进行判断
 * true：有包子
 *      包子铺调用wait方法进入等待状态
 * false：无包子
 *      包子铺生产包子
 *      增加一些趣味性：交替生产包子
 *              有两种状态(i%2 ==0)
 *      包子铺生产好了包子
 *      修改包子的状态true 有
 *      唤醒吃货线程，让吃货线程吃包子
 *
 * 注意：
 *      包子铺线程和包子线程关系-->通信（互斥）
 *      必须同时同步技术保证两个线程只有一个在执行
 *      锁对象必须保证唯一，可以用包子对象作为锁对象
 *      包子铺类和吃货类必须把包子对象作为参数传递进来
 *              1、需要在成员变量创建一个包子变量
 *              2、使用带参数的构造方法，为这个包子变量赋值
 */

public class BaoziPu extends Thread{
    //1、需要在成员变量创建一个包子变量
    private Baozi bz;

    //2、使用带参数的构造方法，为这个包子变量赋值
    public BaoziPu(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        //定义一个变量
        int count = 0;

        while (true) {
            //必须同时同步技术保证两个线程只有一个在执行
            synchronized (bz) {
                //对包子的状态进行判断
                if(bz.flag == true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                //被唤醒之后，包子铺生产包子
                //增加一些趣味性：交替生产包子
                if(count % 2 == 0){
                    //生产薄皮三鲜包子
                    bz.pi = "薄皮";
                    bz.xian = "三鲜馅";
                }else{
                    //生产冰皮牛肉大葱包子
                    bz.pi = "冰皮";
                    bz.xian = "牛肉大葱馅";
                }

                count++;
                System.out.println("包子铺正在生产："+bz.pi+bz.xian+"包子");
                //生产包子需要3秒
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                //包子铺生产好了包子
                //修改包子的状态true 有
                bz.flag = true;

                //唤醒吃货线程，让吃货线程吃包子
                bz.notify();
                System.out.println("包子铺生产好了："+bz.pi+bz.xian+"包子，吃货可以开吃了");
            }
        }
    }
}
