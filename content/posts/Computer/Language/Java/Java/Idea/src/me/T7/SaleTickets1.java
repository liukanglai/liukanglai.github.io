package me.T7;

/**
 * @author liukanglai
 * @date 5/29/21 - 9:42 AM
 */

public class SaleTickets1 {

    public static class Sale implements Runnable {
        private int saleTickets = 0;

        @Override
        public void run() {
            while (true) {
                if(saleTickets < 100) {
                    saleTickets++;
                    System.out.println(Thread.currentThread().getName() + "正在售票, 还有" + String.valueOf(100 - saleTickets) + "张");
                }
                else {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {

        Sale sale = new Sale();
        Thread thread0 = new Thread(sale);
        Thread thread1 = new Thread(sale);
        Thread thread2 = new Thread(sale);

        thread0.setName("win0");
        thread0.setName("win1");
        thread0.setName("win2");

        thread0.start();
        thread1.start();
        thread2.start();
    }
}