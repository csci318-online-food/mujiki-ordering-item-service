package com.csci318.microservice.item.Controllers;

import com.csci318.microservice.item.DTOs.ItemDTORequest;
import com.csci318.microservice.item.DTOs.ItemDTOResponse;
import com.csci318.microservice.item.Entities.Item;
import com.csci318.microservice.item.Services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${api.endpoint.base-url}/items")
public class ItemController {

    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<ItemDTOResponse> createItemForRestaurant(@RequestBody ItemDTORequest itemDTORequest, @RequestParam(name = "restaurantId") UUID restaurantId) {
        try {
            ItemDTOResponse itemDTOResponse = this.itemService.createItemForRestaurant(itemDTORequest, restaurantId);
            if (itemDTOResponse == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(itemDTOResponse);
        } catch (Exception e) {
            return null;
        }
    }
}
