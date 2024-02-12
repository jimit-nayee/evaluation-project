package com.evaluation.service.impl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.evaluation.custom_exception.ItemNotFoundException;
import com.evaluation.dto.ItemDto;
import com.evaluation.entity.Item;
import com.evaluation.repository.ItemRepo;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ItemServiceImplTest {

    @Mock
    private ItemRepo itemRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ItemServiceImpl itemService;

    private ItemDto itemDto;
    private Item item;
    private Pageable pageable;
    private List<Item> itemList;

    @BeforeEach
    public void setup() {
        itemDto = new ItemDto();
        itemDto.setId(1L);
        itemDto.setName("Test Item");

        item = new Item();
        item.setId(1L);
        item.setName("Test Item");

        pageable = Pageable.unpaged();

        itemList = new ArrayList<>();
        itemList.add(item);
    }

    @Test
    void testAddItem() {
        when(modelMapper.map(itemDto, Item.class)).thenReturn(item);
        when(itemRepo.save(item)).thenReturn(item);

        ItemDto savedItemDto = itemService.addItem(itemDto);

        assertEquals(itemDto.getId(), savedItemDto.getId());
        assertEquals(itemDto.getName(), savedItemDto.getName());
    }

    @Test
    void testGetAllPaginateItem() {
        Page<Item> page = new PageImpl<>(itemList);
        when(itemRepo.findAll(pageable)).thenReturn(page);
        when(modelMapper.map(item, ItemDto.class)).thenReturn(itemDto);

        Page<ItemDto> itemDtoPage = itemService.getAllPaginateItem(pageable);

        assertEquals(1, itemDtoPage.getTotalElements());
        assertEquals(itemDto.getId(), itemDtoPage.getContent().get(0).getId());
        assertEquals(itemDto.getName(), itemDtoPage.getContent().get(0).getName());
    }
    
    @Test
     void testGetById() throws ItemNotFoundException {
        when(itemRepo.findById(itemDto.getId())).thenReturn(Optional.of(item));
        when(modelMapper.map(item, ItemDto.class)).thenReturn(itemDto);

        ItemDto foundItemDto = itemService.getById(itemDto.getId());

        assertEquals(itemDto.getId(), foundItemDto.getId());
        assertEquals(itemDto.getName(), foundItemDto.getName());
    }

    @Test
     void testGetByIdThrowsItemNotFoundException() {
        Long id = 1L;
        when(itemRepo.findById(id)).thenReturn(Optional.of(item));

        assertThrows(ItemNotFoundException.class, () -> itemService.getById(id));
    }

    @Test
     void testDeleteById() {
        Long id = 1L;

        String result = itemService.deleteById(id);

        verify(itemRepo).deleteById(id);
        assertEquals("Item deleted Successfully", result);
    }
}
