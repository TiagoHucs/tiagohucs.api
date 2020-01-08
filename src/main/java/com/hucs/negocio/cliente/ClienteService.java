package com.hucs.negocio.cliente;

import com.hucs.negocio.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EmailService emailService;

    public List<Cliente> list(){
        return repository.findAll();
    }

    public void save(Cliente cliente){
        repository.save(cliente);
        //emailService.sendEmail("Cadastro", "cliente cadastrado" + cliente.getNome());
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
