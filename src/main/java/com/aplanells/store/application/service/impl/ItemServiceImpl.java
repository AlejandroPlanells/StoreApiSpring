package com.aplanells.store.application.service.impl;

import com.aplanells.store.application.dto.ItemDto;
import com.aplanells.store.application.mapper.ItemMapper;
import com.aplanells.store.application.service.ItemService;
import com.aplanells.store.domain.entity.Item;
import com.aplanells.store.domain.persistence.ItemPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemPersistence persistence;
    private final ItemMapper mapper;

    @Autowired
    public ItemServiceImpl(ItemPersistence persistence, ItemMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public List<ItemDto> getAllItemsByCategory(Long categoryId) {
        List<Item> items = this.persistence.getAllItemsByCategory(categoryId);
        return this.mapper.toDto(items);
    }

    @Override
    public Optional<ItemDto> getItemById(Long itemId) {
        return this.persistence.getItemById(itemId).map(this.mapper::toDto);
    }

    @Override
    public ItemDto saveItem(ItemDto itemDto) {
        Item itemSaved = this.persistence.saveItem(this.mapper.toEntity(itemDto));
        return this.mapper.toDto(itemSaved);
    }

    @Override
    public void deleteItem(Long itemId) {
        this.persistence.deleteItem(itemId);
    }
}
