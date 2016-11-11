package cn.mingyuan.threaddemos.interrupt;

/**
 * @author jiangmingyuan@myhaowai.com
 * @version 2016/11/11 10:39
 * @since jdk1.8
 */
public class InterruptTest2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            System.out.println("hello");
            boolean b = checkInterruptByisInterruptedMethd();
//            boolean b = checkInterruptByThreadInterruptedMethod();
            if (!b) {
                break;
            }
            System.out.println("hello2");
        }
    }

    /**
     * Thread.interrupted()方法会清除中断状态。导致第二次调用本方法时返回false
     *
     * @return
     */
    public boolean checkInterruptByThreadInterruptedMethod() {
        if (Thread.interrupted()) {
            System.out.println("thread interrupted");
        }

        if (Thread.interrupted()) {
            System.out.println("thread interrupted2");
            return false;
        }
        return true;
    }

    /**
     * isInterrupted方法，检测中断状态，不会清除中断标记，中断后第二次调用isInterrupted()方法仍返回true
     *
     * @return
     */
    public boolean checkInterruptByisInterruptedMethd() {
        if (this.isInterrupted()) {
            System.out.println("thread interrupted");
        }
        if (this.isInterrupted()) {
            System.out.println("thread interrupted2");
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptTest2 interruptTest2 = new InterruptTest2();
        interruptTest2.start();
        System.out.println("begin interrupt");
        interruptTest2.interrupt();
        System.out.println("interrupt invoked");
    }
}
