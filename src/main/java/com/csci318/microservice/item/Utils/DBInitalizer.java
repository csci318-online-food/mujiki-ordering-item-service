package com.csci318.microservice.item.Utils;

import com.csci318.microservice.item.Repositories.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitalizer implements CommandLineRunner {

    private final ItemRepository itemRepository;

    public DBInitalizer(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // if (itemRepository.count() == 0) {
        // }
    }
}
