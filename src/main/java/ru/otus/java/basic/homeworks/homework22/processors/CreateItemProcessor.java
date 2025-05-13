package ru.otus.java.basic.homeworks.homework22.processors;


import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework22.HttpRequest;
import ru.otus.java.basic.homeworks.homework22.application.Item;
import ru.otus.java.basic.homeworks.homework22.application.ItemsRepository;
import ru.otus.java.basic.homeworks.homework22.exceptions.BadRequestException;
import ru.otus.java.basic.homeworks.homework22.utils.LoggerUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class CreateItemProcessor implements RequestProcessor {
    private static final Logger logger = LoggerUtil.getLogger();

    private ItemsRepository itemsRepository;

    public CreateItemProcessor(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        Gson gson = new Gson();
        Item newItem = gson.fromJson(request.getBody(), Item.class);

        // Проверка названия
        if (newItem.getTitle() == null || newItem.getTitle().trim().isEmpty()) {
            logger.warning("Пустое название продукта в теле запроса: " + request.getBody());
            throw new BadRequestException("INVALID_TITLE", "Название продукта не может быть пустым");
        }

        // Проверка цены (BigDecimal)
        if (newItem.getPrice() == null || newItem.getPrice().signum() < 0) {
            logger.warning("Неверная цена продукта (null или < 0) в теле запроса: " + request.getBody());
            throw new BadRequestException("INVALID_PRICE", "Цена не может быть пустой или отрицательной");
        }

        itemsRepository.addNewItem(newItem);
        String response = "" +
                "HTTP/1.1 201 Created\r\n" +
                "Content-Type: application/json\r\n" +
                "\r\n";
        output.write(response.getBytes(StandardCharsets.UTF_8));
    }
}