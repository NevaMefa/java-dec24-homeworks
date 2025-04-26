package ru.otus.java.basic.homeworks.homework18;

public class AppHw18 {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> appleBox = new Box<>();
        Box<Apple> anotherAppleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.addFruit(apple);
        appleBox.addFruit(new Apple());

        orangeBox.addFruit(orange);
        orangeBox.addFruit(new Orange());

        System.out.println("Вес яблочной коробки: " + appleBox.getWeight());
        System.out.println("Вес апельсиновой коробки: " + orangeBox.getWeight());

        System.out.println("Коробки равны по весу? " + appleBox.compare(orangeBox));

        appleBox.transferFruitsTo(anotherAppleBox);
        System.out.println("Теперь в первой коробке: " + appleBox.getCount() + " фруктов");
        System.out.println("А во второй: " + anotherAppleBox.getCount() + " фруктов");
    }
}
