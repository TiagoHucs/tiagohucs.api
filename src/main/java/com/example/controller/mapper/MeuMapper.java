package com.example.controller.mapper;

import com.example.controller.model.ItemVO;
import com.example.controller.model.OrcamentoVO;
import com.example.model.Item;
import com.example.model.Orcamento;
import com.example.model.Produto;
import com.example.repository.ProdutoRepository;
import com.example.service.ClienteService;
import com.example.service.ItemService;
import com.example.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeuMapper {

    Orcamento orcamento;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Orcamento map(OrcamentoVO vo){
        orcamento = Orcamento.builder()
                .dataEmissao(LocalDate.now())
                .cliente(clienteService.findById(vo.getCliente().getId()))
                .build();
        orcamento.setItens(mapItens(vo.getItens()));
        return orcamento;
    }

    private List<Item> mapItens(List<ItemVO> list){
        List<Item> realList = new ArrayList<>();
        for (ItemVO vo:list) {
            Item i = Item.builder().build();
            Long id = vo.getProduto().getId();
            Produto p = produtoRepository.findById(id).get();
            i.setProduto(p);
            i.setQuantidade(vo.getQuantidade());
            orcamento.addItem(i);
            realList.add(i);
        }
        return realList;
    }


}
