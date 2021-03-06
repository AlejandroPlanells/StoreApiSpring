package com.aplanells.store.application.mapper;

import com.aplanells.store.application.dto.ItemDto;
import com.aplanells.store.domain.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ItemMapper extends EntityMapper<ItemDto, Item>{

    @Override
    @Mapping(source = "categoryId", target = "category")
    Item toEntity(ItemDto dto);

    @Override
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    ItemDto toDto(Item entity);
}
