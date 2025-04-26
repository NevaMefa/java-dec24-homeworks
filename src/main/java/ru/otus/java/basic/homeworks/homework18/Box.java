package ru.otus.java.basic.homeworks.homework18;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001f;
    }

    public void transferFruitsTo(Box<T> otherBox) {
        if (this == otherBox) {
            System.out.println("Нельзя пересыпать фрукты в ту же коробку.");
            return;
        }

        if (this.fruits.isEmpty()) {
            System.out.println("Коробка пуста, нечего пересыпать.");
            return;
        }

        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
        System.out.println("Фрукты успешно пересыпаны.");
    }

    public int getCount() {
        return fruits.size();
    }
}
