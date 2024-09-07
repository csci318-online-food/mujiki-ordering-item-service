package com.csci318.microservice.item.Services;

import com.csci318.microservice.item.DTOs.ItemDTORequest;
import com.csci318.microservice.item.DTOs.ItemDTOResponse;
import com.csci318.microservice.item.Entities.Relation.Restaurant;

import java.util.UUID;

public interface ItemService {

    ItemDTOResponse createItemForRestaurant(ItemDTORequest itemDTORequest, UUID restaurantId);
}
