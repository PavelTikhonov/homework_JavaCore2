package homework.lesson5;

import java.util.Arrays;

public class MyThread {
    private static final int SIZE = 50;
    private static final int HALF = SIZE / 2;
    private float[] arrFull = new float[SIZE];
    private float[] arrFull1 = new float[SIZE];

    public MyThread(){
        for (int i = 0; i < SIZE; i++) {
            arrFull[i] = 1;
            arrFull1[i] = 1;
        }
    }

    private void expression(float[] aArr, int start, int len){
        for (int i = 0; i < len; i++) {
            /*
            aArr[i] = (float) (aArr[i] * Math.sin(0.2f + (float) ((start + i) / 5)) *
                    Math.cos(0.2f + (float) ((start + i) / 5)) * Math.cos(0.4f + (float) ((start + i) / 2)));*/
            aArr[i] = i;
            System.out.println(aArr[i]);

        }
    }

    public void calculateFullSize() {
        this.expression(arrFull, 0, arrFull.length);
    }

    public void calculateHalfSize(){
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arrFull1, 0, arr1, 0, HALF);
        System.arraycopy(arrFull1, HALF, arr2, 0, HALF);

        Runnable r1 = () -> {
            this.expression(arr1, 0, arr1.length);
        };
        Runnable r2 = () -> {
            this.expression(arr2, HALF, arr2.length);
        };
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

    public void equals(){
        if(Arrays.equals(arrFull, arrFull1)){
            System.out.println("Массивы arrFull и arrFull1 идентичны");
        } else {
            System.out.println("Массивы arrFull и arrFull1 не идентичны");
        }
    }
}
