package ru.otus.java.basic.homeworks.homework9.transport;

public class AllVehicle extends Transport {
    private int fuel;

    public AllVehicle(int fuel) {
        super("allVehicle");
        this.fuel = fuel;
    }

    public AllVehicle(String name) {
        super(name);
    }


    @Override
    public void info() {
        System.out.println(transport + fuel);
    }
}
