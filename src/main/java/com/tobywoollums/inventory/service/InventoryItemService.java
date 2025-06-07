package com.tobywoollums.inventory.service;
import java.util.List;
import com.tobywoollums.inventory.dto.InventoryItemDto;

public interface InventoryItemService {
    InventoryItemDto createItem(InventoryItemDto dto);
    List<InventoryItemDto> getAllItems();
    InventoryItemDto getItemById(Long id);
    InventoryItemDto updateItem(Long id, InventoryItemDto dto);
    void deleteItem(Long id);
}
