package com.muthu.rest.webservice.restful_webservice.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.muthu.rest.webservice.restful_webservice.jpa.PostRepository;
import com.muthu.rest.webservice.restful_webservice.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UsersDaoService service;
	
	private UserRepository userRepo;
	
	private PostRepository postRepo;
	
	public UserResource(UsersDaoService service, UserRepository userInterface, PostRepository postRepo) {
		this.service = service;
		this.userRepo = userInterface;
		this.postRepo = postRepo;
	}
	
	@GetMapping(path = "/users")
	public List<Users> retrieveAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public Users findById(@PathVariable Integer id) {
		
		Optional<Users> findUser = userRepo.findById(id);
		
		if(findUser.isEmpty()) {
			throw new userNotFoundException("id" + id);
		}
		return findUser.get();
	}
	
	@GetMapping(path = "/users/{id}/post")
	public List<Post> findPostbyId(@PathVariable Integer id) {
		
		Optional<Users> findUser = userRepo.findById(id);
		
		if(findUser.isEmpty()) {
			throw new userNotFoundException("id" + id);
		}
		return findUser.get().getPosts();
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Users> saveUser(@Valid @RequestBody Users user) {
		Users savedUser = userRepo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri(); 
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path = "/users/{id}/post")
	public ResponseEntity<Post> SavepostByUser(@PathVariable int id, @Valid @RequestBody Post post) {
		
		Optional<Users> users = userRepo.findById(id);
		
		if(users.isEmpty()) {
			throw new userNotFoundException("id"+id);
		}
		
		post.setUser(users.get());
		
		Post savedPost = postRepo.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri(); 
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path ="/users/{id}")
	public String deleteUser(@PathVariable Integer id) {
		
		userRepo.deleteById(id);
		
		/*List<Users> alluser = userRepo.findAll();
		System.out.print("findUser"+findUser);
		System.out.print("alluser alluser"+alluser);
		if(findUser.isEmpty()) {
			throw new userNotFoundException("id" + id);
		} else {
			alluser.remove(findUser.get());
		} */
		return "User successfully deleted";
	}
	
	
}
