package com.example.service;

import com.example.model.Cliente;
import com.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> list(){
        return repository.findAll();
    }

    public void save(Cliente cliente){
        repository.save(cliente);
    }

    public Cliente findById(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public long count(){
        return repository.count();
    };
}
