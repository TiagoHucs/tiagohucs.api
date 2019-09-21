package cenarios;

import com.example.model.Cliente;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCliente extends AbstractTest {

    @Test
    public void ct1_cadastratCliente(){
        Cliente sadrak = Cliente.builder().nome("Sadrak").cpfcnpj("01234567890").build();
        clienteService.save(sadrak);
    }

    @Test
    public void ct2_editarCliente(){
        Cliente cliente = clienteService.findById(1L);
        cliente.setNome("Juca");
        clienteService.save(cliente);
    }

    @Test
    public void ct3_excluirCliente(){
        Cliente cliente = clienteService.findById(1L);
        clienteService.deleteById(cliente.getId());
    }


}
