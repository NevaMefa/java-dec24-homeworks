package ru.otus.java.basic.homeworks.practic;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * .equals Метод для сравнения объектов
 * смотрит равны ли два объекта с точки звения содержимого
 * String str1 = new String("hello");
 * String str2 = new String("hello");
 * System.out.println(str1 == str2);       false, разные объекты в памяти
 * System.out.println(str1.equals(str2));  true, содержимое строк одинаково
 */
public class Practic {
    public static void main(String[] args) {
        gameToGuessWorld();
    }

    private static void gameToGuessWorld() {
        Scanner scanner = new Scanner(System.in);
        //Массив с загаданными словами
        String[] fruits = {"apple", "pineapple", "melon",
                "lemon", "peach", "strawberry", "orange", "watermelon"};
        //Переменная для выделения рандомного значения из массива
        int randomIndex = (int) (Math.random() * fruits.length);
        //кладем рандомное значение из массива в строковую переменную
        String wordToGuess = fruits[randomIndex];
        System.out.println("Игра угадайте фрукт началась!");
        //переменная, следит угадал ли игрок
        boolean win = false;
        //делаем цикл и говорим, что играем до победы
        while (!win) {
            //считываем что ввел игрок
            String inputFruit = scanner.next();
            //сравниваем загаданное с введеным
            if (wordToGuess.equals(inputFruit)) {
                //уведомили о победе
                System.out.println("Вы победили!");
                win = true;
            } else {
                //два массива для сравнения загаданного и введенного
                //char[] позволяет хранить символы
                char[] toGuess = wordToGuess.toCharArray();
                char[] input = inputFruit.toCharArray();
                //цикл проверяет есть ли совпадение в символах
                for (int i = 0; i < toGuess.length && i < input.length; i++) {
                   //если совпали то выводится *
                    if (toGuess[i] == input[i]) {
                        System.out.print(input[i]);
                    } else {
                        System.out.print("*");
                    }
                }
                //вычисляем минимальную длину между словами
                int minLength = Math.min(wordToGuess.length(), inputFruit.length());
                //циклом добавляем *  что б итоговая длина строки была 10
                for (int i = 0; i < (10 - minLength); i++) {
                    System.out.println("*");
                }
                //печатаем строку подсказки с буквами и звездами
                System.out.println();
                //даем еще попытку
                System.out.println("Вы не угадали, попробуйте ещё раз!");
            }
        }
    }
}