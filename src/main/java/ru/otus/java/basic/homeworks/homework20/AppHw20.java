package ru.otus.java.basic.homeworks.homework20;

public class AppHw20 {
    private final Object lock = new Object();
    private char current = 'A';
    private static final int COUNT = 5;

    public static void main(String[] args) {
        AppHw20 app = new AppHw20();
        new Thread(() -> app.print('A', 'B')).start();
        new Thread(() -> app.print('B', 'C')).start();
        new Thread(() -> app.print('C', 'A')).start();
    }

    public void print(char letter, char next) {
        for (int i = 0; i < COUNT; ) {
            synchronized (lock) {
                if (current == letter) {
                    System.out.print(letter);
                    current = next;
                    i++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}