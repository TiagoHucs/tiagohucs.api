package com.hucs;

import com.hucs.security.enums.ProfileEnum;
import com.hucs.security.user.User;
import com.hucs.security.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hucs.security.user.UserRepository;

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
  CommandLineRunner init(UserRepository userRepository,UserService userService, PasswordEncoder passwordEncoder) {
    return args -> {
      initUsers(userRepository,userService, passwordEncoder);
    };
  }

  private void initUsers(UserRepository userRepository, UserService userService, PasswordEncoder passwordEncoder) {
    User admin = new User();
    admin.setEmail("tiagohucs@gmail.com");
    admin.setPassword(passwordEncoder.encode("123"));
    admin.setProfile(ProfileEnum.ROLE_ADMIN);

    User find = userRepository.findByEmail("tiagohucs@gmail.com");
    if (find == null) {
      //userRepository.save(admin);
      userService.createOrUpdate(admin);
    }
  }

}
