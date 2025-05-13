package ru.otus.java.basic.homeworks.homework22.processors;


import ru.otus.java.basic.homeworks.homework22.HttpRequest;
import ru.otus.java.basic.homeworks.homework22.exceptions.BadRequestException;
import ru.otus.java.basic.homeworks.homework22.utils.LoggerUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class CalculatorProcessor implements RequestProcessor {
    private static ru.otus.java.basic.homeworks.homework22.utils.LoggerUtil LoggerUtil;
    private static final Logger logger = LoggerUtil.getLogger();

    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        if (!request.containsParameter("a")) {
            throw new BadRequestException("INCORRECT_REQUEST_DATA", "Отсутствует параметр запроса 'a'");
        }
        if (!request.containsParameter("b")) {
            throw new BadRequestException("INCORRECT_REQUEST_DATA", "Отсутствует параметр запроса 'b'");
        }

        int a, b;
        try {
            a = Integer.parseInt(request.getParameter("a"));
        } catch (NumberFormatException e) {
            logger.warning("Параметр 'a' не является числом: " + request.getParameter("a"));
            throw new BadRequestException("INVALID_PARAM", "Параметр 'a' должен быть целым числом");
        }

        try {
            b = Integer.parseInt(request.getParameter("b"));
        } catch (NumberFormatException e) {
            logger.warning("Параметр 'b' не является числом: " + request.getParameter("b"));
            throw new BadRequestException("INVALID_PARAM", "Параметр 'b' должен быть целым числом");
        }

        String response = "" +
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "\r\n" +
                "<html><body><h1>" + a + " + " + b + " = " + (a + b) + "</h1></body></html>";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}
