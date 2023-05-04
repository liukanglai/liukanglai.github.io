package me.T7;

/**
 * @author liukanglai
 * @date 5/9/21 - 9:17 PM
 */
public class Call {


    static class CallSomeone extends Thread{
        String[] callMan = new String[]{"章", "刘", "万"};
        String beMan = new String("孙");
        int who;
        CallSomeone(int who) {
            this.who = who;
        }

        @Override
        public void run() {
            synchronized (Lock.lock) {
                String time = String.valueOf(Math.random() * 20);
                System.out.println(callMan[who] + "打电话给了" + beMan + "; 打了" + time + "分钟");
                System.out.println(callMan[who] + "挂了" + beMan + "的电话");
            }
        }
    }

    public static void main(String[] args) {
        CallSomeone call0 = new CallSomeone(0);
        CallSomeone call1 = new CallSomeone(1);
        CallSomeone call2 = new CallSomeone(2);

        call0.start();
        call1.start();
        call2.start();
    }
}
class Lock {
    public static final Object lock = new Object();
    public static Boolean flag = true;
    //static int y = 150, x = 20;
}