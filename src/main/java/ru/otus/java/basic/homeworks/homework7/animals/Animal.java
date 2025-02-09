package ru.otus.java.basic.homeworks.homework7.animals;

public class Animal {
    String name;
    int speedRun;
    int speedSwim;
    int endurance;
    int expEndurance;

    public void info() {
        System.out.println(name + " " + speedRun + " " + speedSwim + " " + endurance);
    }


    public void run(int distance) {
        this.endurance = endurance - distance;
        System.out.println(name + " побежал на " + distance + endurance );
    }

    public void swim(int distance) {
        System.out.println("Животное плывет");
    }
}
