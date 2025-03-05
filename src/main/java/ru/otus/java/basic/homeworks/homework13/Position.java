package ru.otus.java.basic.homeworks.homework13;

public enum Position implements javax.swing.text.Position {
    MANAGER, DIRECTOR, DRIVER, ENGINEER, SENIOR_MANAGER, DEVELOPER, QA,
    JANITOR, PLUMBER, BRANCH_DIRECTOR, JUNIOR_DEVELOPER;

    @Override
    public int getOffset() {
        return 0;
    }
}
