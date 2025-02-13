package ru.otus.java.basic.homeworks.homework8;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

public void eat(Plate plate){
        if (plate.getQuantity() >= appetite){
            plate.setQuantity(plate.getQuantity() - appetite);
            hungry = true;
            System.out.println(name + " поел");
            return;
        }
    System.out.println(name + " недовольный");
}


}
