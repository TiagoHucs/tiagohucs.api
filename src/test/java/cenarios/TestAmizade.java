package cenarios;

import com.hucs.negocio.amizade.AmizadeService;
import com.hucs.negocio.perfil.Perfil;
import com.hucs.negocio.perfil.PerfilRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestAmizade extends AbstractTest{


    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private AmizadeService amizadeService;

    @Test
    public void adicionaAmigos(){
        Perfil hugo = perfilRepository.save(Perfil.builder().nome("Hugo").build());
        Perfil hucs = perfilRepository.save(Perfil.builder().nome("Hucs").build());
        Perfil adri = perfilRepository.save(Perfil.builder().nome("Adri").build());
        amizadeService.adicionaAmigo(hugo,hucs);
        amizadeService.adicionaAmigo(hugo,hucs);
        amizadeService.adicionaAmigo(hugo,adri);
        int qtdAmigos = amizadeService.getAmigos(hugo.getId()).size();
        Assert.assertEquals(2,qtdAmigos);
    }


}
