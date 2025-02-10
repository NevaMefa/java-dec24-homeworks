package ru.otus.java.basic.homeworks.homework7.animals;

public class Cat extends Animal {
    public Cat(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.endurance = endurance;
    }

    @Override
    public void swim(int distance) {
        System.out.println("Я котик, я не плаваю");
    }
}
