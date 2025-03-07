package ru.otus.java.basic.homeworks.homework13;

import java.util.Set;

public enum Position implements javax.swing.text.Position {
    MANAGER, DIRECTOR, DRIVER, ENGINEER, SENIOR_MANAGER, DEVELOPER, QA,
    JANITOR, PLUMBER, BRANCH_DIRECTOR, JUNIOR_DEVELOPER;


    public static Set<Position> getManagerPos() {
        return Set.of(
                MANAGER, DIRECTOR, SENIOR_MANAGER, BRANCH_DIRECTOR);
    }

    public static Set<Position> getEmployeePos() {
        return Set.of(
                DRIVER, ENGINEER, QA, JANITOR, JUNIOR_DEVELOPER, PLUMBER);
    }

    @Override
    public int getOffset() {
        return 0;
    }
}
