package com.hucs.negocio.orcamento;

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
