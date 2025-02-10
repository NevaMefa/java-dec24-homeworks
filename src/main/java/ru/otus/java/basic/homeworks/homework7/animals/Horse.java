package ru.otus.java.basic.homeworks.homework7.animals;

public class Horse extends Animal {
    public Horse(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
    }

    @Override
    public void swim(int distance) {
        this.endurance = endurance - (distance * 4);
        if (this.endurance <= 0) {
            System.out.println("im so tired");
        } else {
            this.time = distance / speedRun;
            System.out.println(name + " проплыл расстояние " + distance + " за(м/с) " + time + " Выносливость " + endurance);
        }
    }
}
