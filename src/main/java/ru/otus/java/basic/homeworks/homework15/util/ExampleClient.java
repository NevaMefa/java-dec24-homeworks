package ru.otus.java.basic.homeworks.homework15.util;

import java.io.*;

public class ExampleClient implements AutoCloseable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public ExampleClient(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void send(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
    }

    public String receive() throws IOException {
        return inputStream.readUTF();
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
        outputStream.close();
    }
}
