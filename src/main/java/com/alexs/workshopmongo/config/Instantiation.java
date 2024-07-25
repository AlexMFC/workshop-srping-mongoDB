package com.alexs.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alexs.workshopmongo.domain.Post;
import com.alexs.workshopmongo.domain.User;
import com.alexs.workshopmongo.dto.AuthorDTO;
import com.alexs.workshopmongo.repositories.PostRepository;
import com.alexs.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();//limpa a base
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Post post1 = new Post(null, sdf.parse("22/09/2024"), "Titulo", "Testando post", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/09/2024"), "Titulo2", "Testando post2", new AuthorDTO(alex));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
	}

}
