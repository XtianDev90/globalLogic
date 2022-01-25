package cl.prueba.globalLogic.mapper;

import cl.prueba.globalLogic.entity.User;
import cl.prueba.globalLogic.out.UserResponse;

public class UserMapper {

	public static UserResponse mapToResponse(User user){
		
		return UserResponse.builder()
				.id(String.valueOf(user.getIdUser()))
				.created(user.getCreated())
				.lastLogin(user.getLastLogin())
				.token(user.getToken())
				.isActive(user.isActive())
				.name(user.getName())
				.email(user.getEmail())
				.password(user.getPassword())
				.phones(user.getPhones())
				.build();			
	}
}
