package cenarios;

import com.example.model.ETipoMedida;
import com.example.model.Item;
import com.example.model.Orcamento;
import com.example.model.Produto;
import com.example.service.OrcamentoService;
import com.example.service.ProdutoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestOrcamento extends AbstractTest{


    Produto produto = new Produto();

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private OrcamentoService orcamentoService;


    @Before
    public void config(){
        produto.setNome("tijolo");
        produto.setTipoMedida(ETipoMedida.UN);
        produto.setValor(BigDecimal.ONE);
        produtoService.save(produto);
    }


    @Test
    public void testeOrcamento(){
        Orcamento orcamento = new Orcamento();
        Item item = new Item();

        item.setProduto(produto);
        item.setQuantidade(50L);

        orcamento.addItem(item);
        orcamentoService.save(orcamento);
    }

}
