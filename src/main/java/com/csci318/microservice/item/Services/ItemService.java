package com.csci318.microservice.item.Services;

import com.csci318.microservice.item.DTOs.ItemDTORequest;
import com.csci318.microservice.item.DTOs.ItemDTOResponse;

import java.util.UUID;

public interface ItemService {

    ItemDTOResponse createItemForRestaurant(ItemDTORequest itemDTORequest, UUID restaurantId);

    ItemDTOResponse getItemById(UUID id);
}
