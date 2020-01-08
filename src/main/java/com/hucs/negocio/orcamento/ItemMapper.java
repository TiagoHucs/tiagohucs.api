package com.hucs.negocio.orcamento;

import com.hucs.negocio.produto.Produto;
import com.hucs.negocio.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Item map(ItemVO vo){
            Item i = Item.builder().build();
            Long id = vo.getProduto().getId();
            Produto p = produtoRepository.findById(id).get();
            i.setProduto(p);
            i.setQuantidade(vo.getQuantidade());
        return i;
    }

}
