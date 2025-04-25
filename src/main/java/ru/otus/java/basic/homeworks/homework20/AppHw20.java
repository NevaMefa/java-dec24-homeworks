package ru.otus.java.basic.homeworks.homework20;

public class AppHw20 {
    private final Object lock = new Object();
    private char current = 'A';
    private static final int COUNT = 5;
    private static final char[] sequence = {'A', 'B', 'C'};

    public static void main(String[] args) {
        AppHw20 app = new AppHw20();
        new Thread(() -> app.print('A')).start();
        new Thread(() -> app.print('B')).start();
        new Thread(() -> app.print('C')).start();
    }

    public void print(char letter) {
        for (int i = 0; i < COUNT; ) {
            synchronized (lock) {
                while (current != letter) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                System.out.print(letter);
                i++;

                // Определяем следующую букву по порядку
                current = nextLetter(letter);

                lock.notifyAll();
            }
        }
    }

    private char nextLetter(char current) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == current) {
                return sequence[(i + 1) % sequence.length];
            }
        }
        throw new IllegalArgumentException("Unexpected letter: " + current);
    }
}
