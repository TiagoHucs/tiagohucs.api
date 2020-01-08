package com.hucs.negocio.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> list(){
        return repository.findAll();
    }

    public void save(Produto produto){
        repository.save(produto);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public long count(){
        return repository.count();
    };
}
