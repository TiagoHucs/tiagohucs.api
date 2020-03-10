import com.hucs.negocio.perfil.PerfilRepository;
import com.hucs.security.user.UserRepository;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class CalcTest extends CucumberRunner {

    Integer resultado;

    @Autowired
    UserRepository repository;

    @When("quando somar {string} com {string}")
    public void quando_somar_com(String string, String string2) {
        resultado = Calc.somar(Integer.decode(string),Integer.decode(string2));
    }

    @Then("O resultado será {string}")
    public void o_resultado_será(String string) {
        Assert.assertEquals(string,resultado.toString());
        repository.findAll();

    }
}
