package cl.prueba.globalLogic.servicio;

import java.util.List;

import cl.prueba.globalLogic.entity.User;
import cl.prueba.globalLogic.in.UserRequest;
import cl.prueba.globalLogic.out.UserResponse;

public interface IUserServices {

	UserResponse createUser(UserRequest user);
	
	UserResponse getUserById(String id);

	List<User> getAllUsers();
}
