package ru.otus.java.basic.homeworks.homework7.animals;

public class Horse extends Animal {
    public Horse(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
        this.endurancePerSwimMeter = 4;
    }

    @Override
    public double swim(int distance) {
        this.endurance = endurance - (distance * endurancePerSwimMeter);
        if (this.endurance <= 0) {
            System.out.println("im so tired");
            return this.time = -1;
        } else {
            System.out.println(name + " проплыл расстояние " + distance + " Выносливость " + endurance);
            return this.time = distance / speedRun;
        }
    }
}
