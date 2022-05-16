package com.aplanells.store.domain.persistence;

import com.aplanells.store.domain.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemPersistence {
    List<Item> getAllItemsByCategory(Long itemId);
    Optional<Item> getItemById(Long itemId);
    Item saveItem(Item item);
    void deleteItem(Long itemId);
}
