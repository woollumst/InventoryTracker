package com.tobywoollums.inventory.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.tobywoollums.inventory.dto.InventoryItemDto;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllItems'");
    }

    @Override
    public InventoryItemDto getItemById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItemById'");
    }

    @Override
    public InventoryItemDto updateItem(Long id, InventoryItemDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateItem'");
    }

    @Override
    public void deleteItem(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteItem'");
    }

    private InventoryItemDto mapToDto(InventoryItem item){
        return new InventoryItemDto(
            item.getId(),
            item.getName(),
            item.getDescription(),
            item.getImageUrl(),
            item.getQuantity(),
            item.getMinQuantity()
        );
    }

    private InventoryItem mapToEntity(InventoryItemDto dto){
            dto.getId(),
            dto.getName(),
            dto.getDescription(),
            dto.getImageUrl(),
            dto.getQuantity(),
            dto.getMinQuantity()
    }
}
