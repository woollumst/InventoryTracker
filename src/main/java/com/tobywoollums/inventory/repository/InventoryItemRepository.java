package com.tobywoollums.inventory.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tobywoollums.inventory.entity.InventoryItem;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long>{

}