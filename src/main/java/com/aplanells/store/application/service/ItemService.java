package com.aplanells.store.application.service;

import com.aplanells.store.application.dto.ItemDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemDto> getAllItemsByCategory(Long categoryId);
    Optional<ItemDto> getItemById(Long itemId);
    ItemDto saveItem(ItemDto itemDto);
    void deleteItem(Long itemId);
}
