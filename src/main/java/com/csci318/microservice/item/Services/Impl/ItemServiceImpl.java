package com.csci318.microservice.item.Services.Impl;

import com.csci318.microservice.item.DTOs.ItemDTORequest;
import com.csci318.microservice.item.DTOs.ItemDTOResponse;
import com.csci318.microservice.item.Domain.Entities.Item;
import com.csci318.microservice.item.Domain.Relations.Restaurant;
import com.csci318.microservice.item.Mappers.Impl.ItemMapper;
import com.csci318.microservice.item.Repositories.ItemRepository;
import com.csci318.microservice.item.Services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private final RestTemplate restTemplate;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Value("${restaurant.url.service}")
    private String RESTAURANT_URL;

    public ItemServiceImpl(RestTemplate restTemplate, ItemRepository itemRepository, ItemMapper itemMapper) {
        this.restTemplate = restTemplate;
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDTOResponse createItemForRestaurant(ItemDTORequest itemDTORequest, UUID restaurantId) {
        Restaurant restaurant = restTemplate.getForObject(RESTAURANT_URL + "/findById/" + restaurantId, Restaurant.class);
        if (restaurant == null) {
            log.error("Restaurant not found with restaurantId: " + restaurantId);
            return null;
        }
        try {
            Item item = new Item();
            item.setName(itemDTORequest.getName());
            item.setRestaurantId(restaurantId);
            item.setDescription(itemDTORequest.getDescription());
            item.setPrice(itemDTORequest.getPrice());
            item.setAvailability(itemDTORequest.isAvailability());
            this.itemRepository.save(item);
            log.info("Item created for restaurant with restaurantId: " + restaurantId);
            return this.itemMapper.toDtos(item);
        } catch (Exception e) {
            log.error("Error creating item for restaurant with restaurantId: " + restaurantId);
            return null;
        }
    }

    @Override
    public ItemDTOResponse getItemById(UUID id) {
        Item item = this.itemRepository.findById(id).orElse(null);
        if (item == null) {
            log.error("Item not found with id: " + id);
            return null;
        }
        return this.itemMapper.toDtos(item);
    }

}
