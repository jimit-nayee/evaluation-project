package com.evaluation.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.evaluation.dto.ItemDto;
import com.evaluation.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ItemControllerTest {
 
    @Autowired
    private MockMvc mockMvc;
 
    @InjectMocks
    private ItemController itemController;
 
    @Mock
    private ItemService itemService;
 
    private ObjectMapper objectMapper = new ObjectMapper();
 
    @BeforeEach
    void setUp() {
    }
 
    @Test
    void testAddItem() throws Exception {
        ItemDto itemDto = new ItemDto();
 
        when(itemService.addItem(any(ItemDto.class))).thenReturn(itemDto);
 
        mockMvc.perform(MockMvcRequestBuilders
                .post("/addItem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemDto))
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.property", Matchers.is("expectedValue")));
    }
 
    @Test
    void testGetAllItem() throws Exception {
        List<ItemDto> itemDtoList = new ArrayList<>();
 
        Page<ItemDto> page = new PageImpl<>(itemDtoList);
 
        when(itemService.getAllPaginateItem(any(Pageable.class))).thenReturn(page);
 
        mockMvc.perform(MockMvcRequestBuilders
                .get("/getAllItem")
                .param("page", "0")
                .param("size", "3")
                .param("sortBy", "id")
                .param("sortDirection", "ASC")
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.content", Matchers.hasSize(3))) 
        .andExpect(jsonPath("$.content[0].property", Matchers.is("expectedValue")));
    }
 
    @Test
    void testGetItemById() throws Exception {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(1L);
 
        when(itemService.getById(1L)).thenReturn(itemDto);
 
        mockMvc.perform(MockMvcRequestBuilders
                .get("/getItemById/1")
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.id", Matchers.is(1L))) 
        .andExpect(jsonPath("$.property", Matchers.is("expectedValue"))); 
    }
 
    @Test
    void testDeleteItemById() throws Exception {
        when(itemService.deleteById(1L)).thenReturn("Item deleted");
 
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/deleteItemById/1")
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$", Matchers.is("Item deleted"))); 
    }
 
    @Test
    void testUpdateItemById() throws Exception {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(1L);
 
        when(itemService.updateItem(any(ItemDto.class))).thenReturn(itemDto);
 
        mockMvc.perform(MockMvcRequestBuilders
                .put("/updateItemById")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemDto))
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(jsonPath("$.id", Matchers.is(1L)))
        .andExpect(jsonPath("$.property", Matchers.is("expectedValue"))); 
    }
}