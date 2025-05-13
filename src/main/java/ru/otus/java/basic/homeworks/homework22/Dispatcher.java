package ru.otus.java.basic.homeworks.homework22;

import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework22.application.ItemsRepository;
import ru.otus.java.basic.homeworks.homework22.exceptions.ErrorDto;
import ru.otus.java.basic.homeworks.homework22.exceptions.BadRequestException;
import ru.otus.java.basic.homeworks.homework22.processors.*;
import ru.otus.java.basic.homeworks.homework22.utils.LoggerUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Dispatcher {
    private static final Logger logger = LoggerUtil.getLogger();

    private Map<String, RequestProcessor> processors;
    private ItemsRepository itemsRepository;
    private RequestProcessor defaultNotFoundProcessor;
    private RequestProcessor defaultStaticResourceProcessor;

    public Dispatcher() {
        this.itemsRepository = new ItemsRepository();
        this.processors = new HashMap<>();
        this.processors.put("GET /hello", new HelloProcessor());
        this.processors.put("GET /calculator", new CalculatorProcessor());
        this.processors.put("GET /items", new GetItemProcessor(itemsRepository));
        this.processors.put("POST /items", new CreateItemProcessor(itemsRepository));
        this.defaultNotFoundProcessor = new DefaultNotFoundProcessor();
        this.defaultStaticResourceProcessor = new DefaultStaticResourcesProcessor();
    }

    public void execute(HttpRequest request, OutputStream output) throws IOException {
        if (Files.exists(Paths.get("static/", request.getUri().substring(1)))) {
            logger.info("Обработка статического ресурса: " + request.getUri());
            defaultStaticResourceProcessor.execute(request, output);
            return;
        }
        if (!processors.containsKey(request.getRoutingKey())) {
            defaultNotFoundProcessor.execute(request, output);
            return;
        }
        try {
            processors.get(request.getRoutingKey()).execute(request, output);
        } catch (BadRequestException e) {
            Gson gson = new Gson();
            ErrorDto errorDto = new ErrorDto(e.getCode(), e.getMessage());
            String errorDtoJson = gson.toJson(errorDto);
            String response = "" +
                    "HTTP/1.1 400 Bad Request\r\n" +
                    "Content-Type: application/json\r\n" +
                    "\r\n" + errorDtoJson;
            output.write(response.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            logger.severe("Необработанная ошибка в обработчике: " + e.getMessage());
            String response = "" +
                    "HTTP/1.1 500 Internal Server Error\r\n" +
                    "Content-Type: text/plain\r\n" +
                    "\r\n" +
                    "Internal Server Error";
            output.write(response.getBytes(StandardCharsets.UTF_8));

        }
    }
}
