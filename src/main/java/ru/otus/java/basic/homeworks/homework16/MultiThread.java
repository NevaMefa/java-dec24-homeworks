package ru.otus.java.basic.homeworks.homework16;

public class MultiThread extends Thread{
private double[] arrayx;
private  int start;
private int end;

    public MultiThread(double[] arrayx, int start, int end) {
        this.arrayx = arrayx;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            arrayx[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
}

