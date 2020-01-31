package cenarios;

import com.hucs.negocio.amizade.AmizadeService;
import com.hucs.negocio.perfil.Perfil;
import com.hucs.negocio.perfil.PerfilRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestAmizade extends AbstractTest{


    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private AmizadeService amizadeService;

    @Test
    public void adicionaAmigo(){
        Perfil hugo = perfilRepository.save(Perfil.builder().nome("Hugo").build());
        Perfil hucs = perfilRepository.save(Perfil.builder().nome("Hucs").build());
        amizadeService.adicionaAmigo(hugo,hucs);
    }


}
