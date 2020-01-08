package com.hucs.negocio.orcamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository repository;

    public List<Orcamento> list(){
        return repository.findAll();
    }

    public void save(Orcamento orcamento){
        repository.save(orcamento);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public long count(){
        return repository.count();
    };
}
