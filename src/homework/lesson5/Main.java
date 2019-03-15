package homework.lesson5;

import java.util.Arrays;

public class Main {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private static float[] arrFull = new float[SIZE];
    private static float[] arrFull1 = new float[SIZE];

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            arrFull[i] = 1;
            arrFull1[i] = 1;
        }

        System.out.println("Время расчета значений элементов массива, мс:");
        long a = System.currentTimeMillis();
        Main.calculateFullSize();
        System.out.println("- arrFull (без применения инструментов многопоточности): " + (System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        Main.calculateHalfSize();
        System.out.println("- arrFull1 (с применением инструментов многопоточности): " + (System.currentTimeMillis() - a));

        if(Arrays.equals(arrFull, arrFull1)){
            System.out.println("Массивы arrFull и arrFull1 идентичны");
        } else {
            System.out.println("Массивы arrFull и arrFull1 не идентичны");
        }

    }

    private static void expression(float[] aArr, int start, int len){
        for (int i = 0; i < len; i++) {
            aArr[i] = (float) (aArr[i] * Math.sin(0.2f + (float) ((start + i) / 5)) *
                    Math.cos(0.2f + (float) ((start + i) / 5)) * Math.cos(0.4f + (float) ((start + i) / 2)));
        }
    }

    private static void calculateFullSize() {
        expression(arrFull, 0, arrFull.length);
    }

    private static void calculateHalfSize(){
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arrFull1, 0, arr1, 0, HALF);
        System.arraycopy(arrFull1, HALF, arr2, 0, HALF);

        Runnable r1 = () -> expression(arr1, 0, arr1.length);
        Runnable r2 = () -> expression(arr2, HALF, arr2.length);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arrFull1, 0, HALF);
        System.arraycopy(arr2, 0, arrFull1, HALF, HALF);
    }

}
