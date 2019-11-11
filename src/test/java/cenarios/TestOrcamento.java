package cenarios;

import com.example.cliente.Cliente;
import com.example.cliente.ETipoCliente;
import com.example.model.*;
import com.example.service.OrcamentoService;
import com.example.service.ProdutoService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class TestOrcamento extends AbstractTest{


    Produto produto = new Produto();
    Cliente cliente = new Cliente();

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

        cliente.setCpfcnpj("123456789");
        cliente.setNome("Juca");
        cliente.setTipoCliente(ETipoCliente.PF);
        clienteService.save(cliente);
    }


    @Test
    public void testeOrcamento(){
        Orcamento orcamento = new Orcamento();
        Item item = new Item();
        item.setProduto(produto);
        item.setQuantidade(50L);
        orcamento.setCliente(cliente);
        orcamento.addItem(item);
        orcamentoService.save(orcamento);
    }

}
