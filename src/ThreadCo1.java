import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;


public class ThreadCo1 {
    static final int COUNT = 20;
    static CountDownLatch cdl = new CountDownLatch(COUNT);

    public static void main(String[] args) throws Exception {
        synchronized (ThreadCo1.class) {
            new Thread(new Teacher(cdl)).start();
            sleep(1);
            for (int i = 0; i < COUNT; i++) {
                new Thread(new Student(i, cdl)).start();
            }
        }
    }

    static class Teacher implements Runnable {

        CountDownLatch cdl;

        Teacher(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("老师发卷子。。。");
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("老师收卷子。。。");
        }

    }

    static class Student implements Runnable {

        CountDownLatch cdl;
        int num;

        Student(int num, CountDownLatch cdl) {
            this.num = num;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("学生(%d)写卷子。。。"+num);
            System.out.println("学生(%d)交卷子。。。"+num);
            cdl.countDown();
        }

    }
}
