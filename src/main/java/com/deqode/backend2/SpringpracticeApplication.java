package com.deqode.backend2;

import com.deqode.backend2.model.User;
import com.deqode.backend2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringpracticeApplication {

	@Autowired
	UserRepository repository;

	@PostConstruct
	public void initUsers(){

		List<User> users= Stream.of(
								new User("anushka", "password", "akesarwani@gmail.com"),
								new User("user1", "pw1", "user1@gmail.com"),
								new User("user2", "pw2", "user2@gmail.com")
							).collect(Collectors.toList());

		repository.saveAll(users);
	}


	public static void main(String[] args) {

		SpringApplication.run(SpringpracticeApplication.class, args);
	}

}
