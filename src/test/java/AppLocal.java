import com.example.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication()
@Configuration
@Profile("release")
public class AppLocal {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}
