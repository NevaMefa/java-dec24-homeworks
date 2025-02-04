package ru.otus.java.basic.homeworks.homework6;

public class User {
    private String surname;
    private String name;
    private String patronymic;
    private int yearBirth;
    private String email;


    public User(String surname, String name, String patronymic, int yearBirth, String email) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.yearBirth = yearBirth;
        this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + surname + " " + name + " " + patronymic + "\nГод рождения: " + yearBirth + "\ne-mail: " + email);
    }
}