package com.tobywoollums.inventory.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItemDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private int stockQuantity;
    private int minStockQuantity;
}