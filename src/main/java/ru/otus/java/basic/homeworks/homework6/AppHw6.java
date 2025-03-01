package ru.otus.java.basic.homeworks.homework6;

import java.time.Year;
import java.util.Arrays;

public class AppHw6 {
    public static void main(String[] args) {
//    User user1 = new User("Pypkin", "Vasya", "Alekseevich", 1998, "user1@test.ru");
        User[] users = {
                new User("Pypkin", "Vasya", "Alekseevich", 1983, "user1@test.ru"),
                new User("Sokolov", "Dmitri", "Dmitrievich", 1977, "user2@test.ru"),
                new User("Shishkin", "Matvei", "Segreevich", 1976, "user3@test.ru"),
                new User("Petrov", "Sergei", "Nikolaevich", 1975, "user4@test.ru"),
                new User("Kuzmin", "Aleksei", "Matveevich", 1963, "user5@test.ru"),
                new User("Sidorov", "Viktor", "Vladimirovich", 1998, "user6@test.ru"),
                new User("Zagirov", "Volodya", "Alekseevich", 1999, "user7@test.ru"),
                new User("Belov", "Igor", "Nikolaevich", 1997, "user8@test.ru"),
                new User("Svetlov", "Nikolai", "Gennadevich", 1996, "user9@test.ru"),
                new User("Michailov", "Leonid", "Evgenevich", 1985, "user10@test.ru")};

        int currentYear = Year.now().getValue();
        int age = 40;
        int searchYear = currentYear - age;
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            if (user.getYearBirth() < searchYear) {
                user.info();
            }
        }
    }

}

