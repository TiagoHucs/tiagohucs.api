package com.example.service;

import com.example.model.Item;
import com.example.model.Produto;
import com.example.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public void save(Item item){
        repository.save(item);
    }

}
