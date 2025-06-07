package com.tobywoollums.inventory.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private String imageUrl;

    private int stockQuantity;

    private int minStockQuantity; // Minimum Stock Threshold
}