package com.tobywoollums.inventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItemDto {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @Size(max = 500, message = "Description must be at most 500 characters")
    private String description;

    @Size(max = 2048, message = "Image URL must be at most 2048 characters")
    private String imageUrl;

    @Min(value = 0, message = "Stock must be 0 or more")
    private int stockQuantity;

    @Min(value = 0, message = "Minimum Stock must be 0 or more")
    private int minStockQuantity;
}