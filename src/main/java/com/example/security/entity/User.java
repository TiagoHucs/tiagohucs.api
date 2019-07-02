package com.example.security.entity;

import com.example.security.enums.ProfileEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "user_entity")
@Getter
@Setter
@EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Long id;

	@NotBlank(message = "Email required")
	@Email(message = "Email invalid")
	@Column
	private String email;

	@NotBlank(message = "Password required")
	@Size(min = 6)
	@Column
	private String password;

	@Column
	private ProfileEnum profile;


}
