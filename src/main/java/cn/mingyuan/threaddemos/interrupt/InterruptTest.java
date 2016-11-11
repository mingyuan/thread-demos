package cn.mingyuan.threaddemos.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author jiangmingyuan@myhaowai.com
 * @version 2016/11/11 10:30
 * @since jdk1.8
 */
public class InterruptTest extends Thread {

    @Override
    public void run() {
        System.out.println("thread start");
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println("begin sleep");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("weak up");
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
                break;
            }
        }
    }

    public static void main(String[] args) {
        InterruptTest interruptTest = new InterruptTest();
        interruptTest.start();
        interruptTest.interrupt();
    }
}
