import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ThreadLocal 为每个线程提供一个私有空间，拥有属于自己的私有变量
 * 解决线程不安全的问题
 */
public class testThreadLocal implements Runnable{
    private static ThreadLocal<SimpleDateFormat> format =
            ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws InterruptedException {
        testThreadLocal t = new testThreadLocal();
        for (int i = 0; i <10 ; i++) {
            Thread tt = new Thread(t,""+i);
//            Thread.sleep(1000);
            tt.start();
        }

        ////线程不安全例子
         /* for (int i = 0; i < 10;i++) {
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(format.parse("2019-12-12 08:30:20"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }*/
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread Name:"+Thread.currentThread().getName()+"  default format:"+format.get().parse("2019-12-11 08:18:36"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        try {
//            Thread.sleep(new Random().nextInt(1000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        format.set(new SimpleDateFormat());
        System.out.println("Thread Name:"+Thread.currentThread().getName()+"  format:"+format.get().toPattern());
    }
}
