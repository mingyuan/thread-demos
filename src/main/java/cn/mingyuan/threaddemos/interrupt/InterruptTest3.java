package cn.mingyuan.threaddemos.interrupt;

/**
 * @author jiangmingyuan@myhaowai.com
 * @version 2016/11/11 11:08
 * @since jdk1.8
 */
public class InterruptTest3 extends Thread {
    @Override
    public void run() {
        doHeavyJob();//interrupt 操作并不会影响当前工作，只是做标记
        System.out.println("job done");
        if (this.isInterrupted()) {
            System.out.println("interrupted");
            return;
        }
    }

    private void doHeavyJob() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println("doing job->"+i);
        }
    }

    public static void main(String[] args) {
        InterruptTest3 interruptTest3 = new InterruptTest3();
        interruptTest3.start();
        interruptTest3.interrupt();
    }
}
