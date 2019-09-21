package com.example.service;

import com.example.model.Cliente;
import com.example.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id).get();
    }

    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}
