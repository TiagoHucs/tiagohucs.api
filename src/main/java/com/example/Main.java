package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.repository.UserRepository;
import com.example.security.entity.User;
import com.example.security.enums.ProfileEnum;

@SpringBootApplication
public class Main {


  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }

  @RequestMapping("/")
  String index() {
    return "index";
  }

  @Bean
  CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    return args -> {
      initUsers(userRepository, passwordEncoder);
    };

  }

  private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    User admin = new User();
    admin.setEmail("admin@helpdesk.com");
    admin.setPassword(passwordEncoder.encode("123456"));
    admin.setProfile(ProfileEnum.ROLE_ADMIN);

    User find = userRepository.findByEmail("admin@helpdesk.com");
    if (find == null) {
      userRepository.save(admin);
    }
  }


}
