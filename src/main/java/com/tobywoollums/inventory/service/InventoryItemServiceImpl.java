package com.tobywoollums.inventory.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.tobywoollums.inventory.dto.InventoryItemDto;
import com.tobywoollums.inventory.entity.InventoryItem;
import com.tobywoollums.inventory.exception.ResourceNotFoundException;
import com.tobywoollums.inventory.repository.InventoryItemRepository;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {
    private final InventoryItemRepository repository;

    public InventoryItemServiceImpl(InventoryItemRepository repository){
        this.repository = repository;
    }

    @Override
    public InventoryItemDto createItem(InventoryItemDto dto) {
        InventoryItem item = mapToEntity(dto);
        InventoryItem saved = repository.save(item);
        return mapToDto(saved);
    }

    @Override
    public List<InventoryItemDto> getAllItems() {
        return repository.findAll().stream()
            .map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public InventoryItemDto getItemById(Long id) {
        InventoryItem item = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
        return mapToDto(item);
    }

    @Override
    public InventoryItemDto updateItem(Long id, InventoryItemDto dto) {
        InventoryItem item = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
        
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setImageUrl(dto.getImageUrl());
        item.setStockQuantity(dto.getStockQuantity());
        item.setMinStockQuantity(dto.getMinStockQuantity());
        
        return mapToDto(repository.save(item));
    }

    @Override
    public void deleteItem(Long id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("Item not found with id " + id);
        repository.deleteById(id);
    }

    private InventoryItemDto mapToDto(InventoryItem item){
        return new InventoryItemDto(
            item.getId(),
            item.getName(),
            item.getDescription(),
            item.getImageUrl(),
            item.getStockQuantity(),
            item.getMinStockQuantity()
        );
    }

    private InventoryItem mapToEntity(InventoryItemDto dto){
        InventoryItem newItem = new InventoryItem();
        //newItem.setId(dto.getId());
        newItem.setName(dto.getName());
        newItem.setDescription(dto.getDescription());
        newItem.setImageUrl(dto.getImageUrl());
        newItem.setStockQuantity(dto.getStockQuantity());
        newItem.setMinStockQuantity(dto.getMinStockQuantity());
        return newItem;
    }
}
