package com.tobywoollums.inventory.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobywoollums.inventory.service.InventoryItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/items")
public class InventoryItemController {
    private final InventoryItemService service;

    public InventoryItemController(InventoryItemService service){
        this.service = service;
    }

    @GetMapping
    public List<InventoryItemDto> getAllItems(){
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItemDto> getItemById(@PathVariable Long id){
        return service.getItemById(id)
            .map(ResponseEntity::ok)
            .else(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InventoryItemDto> createItem(@Valid @RequestBody InventoryItemDto dto){
        InventoryItemDto created = service.createItem(dto);
        URI location = ServletUriComponentBuilder.fromCurrentRequest()
            .path("id")
            .buildAndExpand(created.getId())
            .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItemDto> updateItem(@PathVariable Long id, @RequestBody InventoryItemDto dto){
        
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        
    }
}
