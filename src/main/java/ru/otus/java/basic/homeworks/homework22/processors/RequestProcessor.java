package ru.otus.java.basic.homeworks.homework22.processors;


import ru.otus.java.basic.homeworks.homework22.HttpRequest;

import java.io.IOException;
import java.io.OutputStream;

public interface RequestProcessor {
    void execute(HttpRequest request, OutputStream output) throws IOException;
}
