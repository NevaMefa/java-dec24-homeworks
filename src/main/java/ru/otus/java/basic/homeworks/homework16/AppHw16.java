package ru.otus.java.basic.homeworks.homework16;

public class AppHw16 extends Thread{
    static int size = 100_000_000;
    static int chunk = size / 4; // Разбиваем массив на 4 части
    static double[] array = new double[size];

    public static void main(String[] args) {

        singleThread();
        multiThreadArray();

    }

    public static <array> void singleThread(){

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Время однопоточного выполнения: %d мс\n", endTime - startTime);
    }

    public static <array> void multiThreadArray(){
        long startTime = System.currentTimeMillis();
        Thread t1 = new MultiThread(array, 0, chunk);
        Thread t2 = new MultiThread(array, chunk, chunk * 2);
        Thread t3 = new MultiThread(array, chunk * 2, chunk * 3);
        Thread t4 = new MultiThread(array, chunk * 3, size);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполения 4х потоков: "+ (endTime - startTime) + "mc");
    }


}
