package com.hucs.security.user;

import com.hucs.negocio.perfil.Perfil;
import com.hucs.security.enums.ProfileEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "TB_USER")
@Getter
@Setter
@EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "USR_ID")
	private Long id;

	@NotBlank(message = "Email required")
	@Email(message = "Email invalid")
	@Column(name = "USR_EMAIL")
	private String email;

	@NotBlank(message = "Password required")
	@Size(min = 6)
	@Column(name = "USR_PASSWORD")
	private String password;

	@Column(name = "USR_PROFILE")
	private ProfileEnum profile;

	@OneToOne
	@JoinColumn(name = "PER_ID")
	private Perfil perfil;


}
