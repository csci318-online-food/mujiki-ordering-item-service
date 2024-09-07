package com.csci318.microservice.item.DTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDTORequest {
    private String name;
    private String restaurantId;
    private String description;
    private double price;
    private boolean availability;
}
