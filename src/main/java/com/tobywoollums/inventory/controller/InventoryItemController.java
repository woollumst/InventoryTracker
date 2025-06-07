package com.tobywoollums.inventory.controller;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tobywoollums.inventory.service.InventoryItemService;
import com.tobywoollums.inventory.dto.InventoryItemDto;

@RestController
@RequestMapping("/api/items")
public class InventoryItemController {
    private final InventoryItemService service;

    public InventoryItemController(InventoryItemService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<InventoryItemDto>> getAllItems(){
        List<InventoryItemDto> items = service.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItemDto> getItemById(@PathVariable Long id){
        InventoryItemDto item = service.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<InventoryItemDto> createItem(@Valid @RequestBody InventoryItemDto dto){
        InventoryItemDto newItem = service.createItem(dto);
        URI location = ServletUriComponentBuilder.fromCurrentRequest()
            .path("id").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItemDto> updateItem(@PathVariable Long id, @RequestBody InventoryItemDto dto){
        InventoryItemDto updatedItem = service.updateItem(id, dto);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
