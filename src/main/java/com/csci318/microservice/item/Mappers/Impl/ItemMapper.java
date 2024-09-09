package com.csci318.microservice.item.Mappers.Impl;

import com.csci318.microservice.item.DTOs.ItemDTORequest;
import com.csci318.microservice.item.DTOs.ItemDTOResponse;
import com.csci318.microservice.item.Entities.Item;
import com.csci318.microservice.item.Mappers.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ItemMapper implements Mapper<Item, ItemDTOResponse, ItemDTORequest> {
    @Override
    public ItemDTOResponse toDtos(Item entity) {
        ItemDTOResponse itemDTOResponse = new ItemDTOResponse();
        itemDTOResponse.setId(entity.getId());
        itemDTOResponse.setName(entity.getName());
        itemDTOResponse.setRestaurantId(entity.getRestaurantId());
        itemDTOResponse.setDescription(entity.getDescription());
        itemDTOResponse.setPrice(entity.getPrice());
        itemDTOResponse.setAvailability(entity.isAvailability());
        return itemDTOResponse;
    }

    @Override
    public Item toEntities(ItemDTORequest dto) {
        Item item = new Item();
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setPrice(dto.getPrice());
        item.setAvailability(dto.isAvailability());
        return item;
    }

    @Override
    public List<ItemDTOResponse> toDtos(List<Item> entities) {
        return entities.stream().map(this::toDtos).collect(Collectors.toList());
    }

    @Override
    public List<Item> toEntities(List<ItemDTORequest> dtos) {
        return dtos.stream().map(this::toEntities).collect(Collectors.toList());
    }
}
