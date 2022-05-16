package com.aplanells.store.infrastructure.persistence;

import com.aplanells.store.domain.entity.Item;
import com.aplanells.store.domain.persistence.ItemPersistence;

import java.util.List;
import java.util.Optional;

public class ItemPersistenceImpl implements ItemPersistence {
    private final ItemRepository itemRepository;

    public ItemPersistenceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItemsByCategory(Long categoryId) {
        return this.itemRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public Optional<Item> getItemById(Long itemId) {
        return this.itemRepository.findById(itemId);
    }

    @Override
    public Item saveItem(Item item) {
        return this.itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        this.itemRepository.deleteById(itemId);
    }
}
