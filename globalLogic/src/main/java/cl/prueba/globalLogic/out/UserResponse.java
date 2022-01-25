package cl.prueba.globalLogic.out;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cl.prueba.globalLogic.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class UserResponse {

	private String id;
    private String name;
    private String email;
    private String password;
    private List<Phone> phones = new ArrayList<>();
	private LocalDateTime created;
	private LocalDateTime lastLogin;
	private String token;
	private boolean isActive;
}
