package ru.otus.java.basic.homeworks.homework12;

public class PhoneBook {
    private String fio;
    private long number;

    public PhoneBook(String fio, long number) {
        this.fio = fio;
        this.number = number;
    }

    public String getFio() {
        return fio;
    }

    public long getNumber() {
        return number;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "PhoneBook{" +
                "number=" + number +
                ", fio='" + fio + '\'' +
                '}';
    }

}
