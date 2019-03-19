package homework.lesson5;

public class Main {


    public static void main(String[] args) {

        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
/*
        MyThread myThread = new MyThread();

        System.out.println("Время расчета значений элементов массива, мс:");
        long a = System.currentTimeMillis();
        myThread.calculateFullSize();
        System.out.println("- arrFull (без применения инструментов многопоточности): " + (System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        myThread.calculateHalfSize();
        System.out.println("- arrFull1 (с применением инструментов многопоточности): " + (System.currentTimeMillis() - a));

        myThread.equals();
*/
    }

}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}