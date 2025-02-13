package ru.otus.java.basic.homeworks.homework8;

public class Plate {
    private int quantity;
    private int maxQuantity = quantity;

    public Plate(int quantity) {
        this.quantity = quantity;
        this.maxQuantity = quantity;
    }

    public void infoPlate() {
        System.out.println("Food " + quantity + " maxFood " + maxQuantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if (quantity > maxQuantity) {
            System.out.println("На тарелке нет места");
        } else {
            this.quantity = quantity;
        }
    }

    public boolean eating(int eatQuantity) {
        if (quantity >= eatQuantity) {
            quantity -= eatQuantity;
            return true;
        }
        return false;
    }
}