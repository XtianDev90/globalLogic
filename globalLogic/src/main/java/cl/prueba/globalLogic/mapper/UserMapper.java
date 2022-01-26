package cl.prueba.globalLogic.mapper;

import cl.prueba.globalLogic.entity.User;
import cl.prueba.globalLogic.out.UserResponse;
import cl.prueba.globalLogic.util.UtilCM;

public class UserMapper {

	public static UserResponse mapToResponse(User user){
		String created = UtilCM.formatoLocalDateTime(user.getCreated());
		String lasLogin = UtilCM.formatoLocalDateTime(user.getLastLogin());
		return UserResponse.builder()
				.id(String.valueOf(user.getIdUser()))
				.created(created)
				.lastLogin(lasLogin)
				.token(user.getToken())
				.isActive(user.isActive())
				.name(user.getName())
				.email(user.getEmail())
				.password(user.getPassword())
				.phones(user.getPhones())
				.build();			
	}
}
