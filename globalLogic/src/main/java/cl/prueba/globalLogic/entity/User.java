package cl.prueba.globalLogic.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
	        name = "UUID",
	        strategy = "org.hibernate.id.UUIDGenerator"
	)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	@Getter
	@Setter
	private UUID idUser;
	
	@Column(name="Name" , nullable = false)
    @NotNull(message = "Debes especificar el nombre del usuario.")
    private String name;
	
	@Column(name="Email" , nullable = false)
    @NotNull(message = "Debes especificar el email del usuario.")
    private String email;
	
	@Column(name="Password" , nullable = false)
    @NotNull(message = "Debes especificar la password del usuario.")
    private String password;
	
	@Column(name="Created" , nullable = false)
	private LocalDateTime created;
	
	@Column(name="LastLogin" , nullable = false)
	private LocalDateTime lastLogin;
	
	@Column(name="Token" , nullable = false)
	private String token;
	
	@Column(name="IsActive" , nullable = false)
	private boolean isActive;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

}
