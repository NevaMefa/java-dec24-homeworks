package ru.otus.java.basic.homeworks.homework7.animals;

public class Animal {
    String name;
    int speedRun; // м/с
    int speedSwim; // м/с
    int endurance; // выносливость
    double time;
    int endurancePerSwimMeter;

    public void info() {
        System.out.println("Имя " + name + " Скорость бега(м/с) " + speedRun + " Скорость плавания(м/с) " + speedSwim + " Выносливость " + endurance);
    }


    public double run(int distance) {
        this.endurance = endurance - distance;
        if (this.endurance <= 0) {
            System.out.println(name + " im so tired, время: " + this.time);
            return this.time = -1;
        } else {
            System.out.println(name + " пробежал расстояние " + distance + " Выносливость " + endurance);
            return this.time = distance / speedRun;
        }
    }

    public double swim(int distance) {
        this.endurance = endurance - (distance * endurancePerSwimMeter);
        if (this.endurance <= 0) {
            System.out.println(name + " im so tired, время: " + this.time);
            return this.time = -1;
        } else {
            System.out.println(name + " проплыл расстояние " + distance + " Выносливость " + endurance);
            return this.time = distance / speedRun;
        }
    }
}

