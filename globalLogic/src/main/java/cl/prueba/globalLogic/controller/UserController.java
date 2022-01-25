package cl.prueba.globalLogic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.prueba.globalLogic.entity.User;
import cl.prueba.globalLogic.in.UserRequest;
import cl.prueba.globalLogic.out.UserResponse;
import cl.prueba.globalLogic.servicio.IUserServices;

@RestController
@EnableAutoConfiguration
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	protected IUserServices userService;
	
	@RequestMapping("hello")
	public String helloWorld() {
		return "Hello !!";
	}
	
	@PostMapping("/sign-up")
	public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userReq){
		return ResponseEntity.ok().body(this.userService.createUser(userReq));
	}
	
	@GetMapping("/login/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable String id){
		return ResponseEntity.ok().body(this.userService.getUserById(id));
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok().body(this.userService.getAllUsers());
	}
}
