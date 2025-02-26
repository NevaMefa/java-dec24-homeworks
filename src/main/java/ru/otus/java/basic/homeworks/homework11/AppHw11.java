package ru.otus.java.basic.homeworks.homework11;

import java.util.ArrayList;

public class AppHw11 {
    public static void main(String[] args) {

        minMaxList(3, 10);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Сумма всех элементов " + sumList(list));
        newNumbForList(list, 3);
        numbListAddOne(list, 5);
    }

    public static ArrayList<Integer> minMaxList(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = max; i >= min; i--) {
            list.add(i);

        }
        System.out.println(list);
        return list;
    }

    public static int sumList(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            sum += num;
        }
        return sum;
    }

    public static ArrayList<Integer> newNumbForList(ArrayList<Integer> numbers, int newNumb) {
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, newNumb);
        }
        System.out.println("Лист после замены элементов" + numbers);
        return numbers;
    }

    public static ArrayList<Integer> numbListAddOne(ArrayList<Integer> numbers, int numb) {
        for (int i = 0; i < numbers.size(); i++) {
            int newNumb = numbers.get(i) + numb;
            numbers.set(i, newNumb);
        }
        System.out.println("Лист после суммирования элементов с новым числом " + numbers);
        return numbers;
    }



}
