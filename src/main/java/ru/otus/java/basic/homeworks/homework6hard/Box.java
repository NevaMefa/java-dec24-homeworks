package ru.otus.java.basic.homeworks.homework6hard;

import java.util.Scanner;

public class Box {
    private int size;
    private String color;
    public boolean isOpened;
    public String item;
    Scanner scanner = new Scanner(System.in);

    public void setItem() {
        if (isOpened) {
            if (this.size == 0) {
                System.out.println("В коробке нет места, вещь не положить");
            } else {
                System.out.println("Коробка открыта, положите вещь");
                this.item = scanner.nextLine();
                System.out.println("Вы положили " + this.item);
                size--;
            }
        } else if (!isOpened) {
            System.out.println("Коробка закрыта, вещь не положить");
        }
    }

    public void deleteItem() {
        if (isOpened) {
            if (this.size == 0 || this.item == null) {
                System.out.println("В коробке и так пусто");
            } else {
                this.item = null;
                System.out.println("Предмет " + item + "Убран");
            }
        } else if (!isOpened) {
            System.out.println("Коробка закрыта, вещь не убрать");
        }
    }


    public void open() {
        this.isOpened = true;
        System.out.println("Коробка открыта");
    }

    public void close() {
        this.isOpened = false;
        System.out.println("Коробка закрыта");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Box(int size, String color, boolean isOpened) {
        this.size = size;
        this.color = color;
        this.isOpened = isOpened;
    }

    public void info() {
        if (isOpened) {
            System.out.println("Размер " + size + " Цвет " + color + " " + "Коробка открыта" + " в ней " + item);
        } else if (!isOpened) {
            System.out.println("Размер " + size + " Цвет " + color + " " + " Коробка закрыта");

        }
    }


}

