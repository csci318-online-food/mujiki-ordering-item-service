package com.csci318.microservice.item.Services.Impl;

import com.csci318.microservice.item.Repositories.ItemRepository;
import com.csci318.microservice.item.Services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private final RestTemplate restTemplate;
    private final ItemRepository itemRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Value("${address.url.service}")
    private String ADDRESS_URL;

    public ItemServiceImpl(RestTemplate restTemplate, ItemRepository itemRepository, ApplicationEventPublisher eventPublisher) {
        this.restTemplate = restTemplate;
        this.itemRepository = itemRepository;
        this.eventPublisher = eventPublisher;
    }
}
