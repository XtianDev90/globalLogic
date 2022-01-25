package cl.prueba.globalLogic.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.prueba.globalLogic.entity.Phone;
import cl.prueba.globalLogic.entity.User;
import cl.prueba.globalLogic.exception.AlreadyExistException;
import cl.prueba.globalLogic.exception.ResourceNotFoundException;
import cl.prueba.globalLogic.in.PhoneRequest;
import cl.prueba.globalLogic.in.UserRequest;
import cl.prueba.globalLogic.mapper.UserMapper;
import cl.prueba.globalLogic.out.UserResponse;
import cl.prueba.globalLogic.repositorio.PhoneRepository;
import cl.prueba.globalLogic.repositorio.UserRepository;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServicesImpl implements IUserServices{

	@Autowired
	protected UserRepository userRepo;
	
	@Autowired
	protected PhoneRepository phoneRepo;
	
	@Override
	public UserResponse createUser(UserRequest userReq) {
		UserResponse response = new UserResponse();
		User user = new User();
		user.setName(userReq.getName().toUpperCase().trim());
		user.setEmail(userReq.getEmail().toUpperCase().trim());
		user.setPassword(userReq.getPassword().trim());
		user.setToken("Falta implementar generador de token JWT");
		user.setCreated(LocalDateTime.now());
		user.setLastLogin(LocalDateTime.now());
		
		Optional<User> existe = this.userRepo.findByEmail(user.getEmail());
		if(existe.isPresent()){
			throw new AlreadyExistException("Usuario ya existe con email : " + user.getEmail());
			
		}else {
			User userDb = this.userRepo.save(user);
			List<PhoneRequest> phones = userReq.getPhones();
			user.getPhones().addAll((phones.stream().map(phone -> {
				
				Phone telefono = new Phone();
				telefono.setCitycode(phone.getCitycode());
				telefono.setContrycode(phone.getContrycode().toUpperCase().trim());
				telefono.setNumber(phone.getNumber());
				telefono.setUser(user);
				phoneRepo.save(telefono);
				return telefono;
				
			}).collect(Collectors.toList())));
			
			User userSaved = this.userRepo.save(user);
			if(userDb != null) {
				response = UserMapper.mapToResponse(user);
			}
			return response;
		}
	}

	@Override
	public UserResponse getUserById(String id) {
		UserResponse response = new UserResponse();
		
		UUID uuid = UUID.fromString(id);
		
		Optional<User> userDb = this.userRepo.findByIdUser(uuid);
		if(userDb.isPresent()){
			response = UserMapper.mapToResponse(userDb.get());
			return response;
		}else {
			throw new ResourceNotFoundException("Usuario no encontrado con id : " + id);
		}
	}
	
	@Override
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}
}
