package com.tobywoollums.inventory.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.tobywoollums.inventory.dto.InventoryItemDto;
import com.tobywoollums.inventory.repository.InventoryItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService {
    private final InventoryItemRepository repository;

    @Override
    public InventoryItemDto createItem(InventoryItemDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createItem'");
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
}
