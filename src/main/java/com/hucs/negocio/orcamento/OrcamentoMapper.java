package com.hucs.negocio.orcamento;

import com.hucs.negocio.produto.ProdutoRepository;
import com.hucs.negocio.cliente.ClienteService;
import com.hucs.negocio.produto.ProdutoService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrcamentoMapper {

    Orcamento orcamento;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private MapperFacade mapper;

    public Orcamento map(OrcamentoVO vo){
        orcamento = Orcamento.builder()
                .dataEmissao(LocalDate.now())
                .cliente(clienteService.findById(vo.getCliente().getId()))
                .build();
        mapItens(vo.getItens());
        return orcamento;
    }

    public OrcamentoVO map(Orcamento obj){
        return OrcamentoVO.builder()
                .id(obj.getId())
               // .cliente(mapper(obj.getCliente(), ClienteVO.class))
                .dataEmissao(obj.getDataEmissao())
                .dataValidade(obj.getDataValidade())
                .build();
    }

    public List<OrcamentoVO> mapAsList(List<Orcamento> list){
        List<OrcamentoVO> listVO = new ArrayList<>();
        for (Orcamento obj: list) {
            listVO.add(map(obj));
        }
        return listVO;
    }

    private void mapItens(List<ItemVO> list){
        for (ItemVO i :list) {
            orcamento.addItem(itemMapper.map(i));
        }
    }

}
