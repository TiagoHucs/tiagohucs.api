package com.hucs.security.user;

import com.hucs.negocio.perfil.Perfil;
import com.hucs.negocio.perfil.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PerfilService perfilService;

	//TODO: verificar se pode ser o CurrentUser
	User currentUser;

	public User getCurrentUser(){
		return this.currentUser;
	}

	public void setCurrentUser(User user){
		this.currentUser = user;
	}

	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	public User createOrUpdate(User user) {
		criaSeNaoExistPerfil(user);
		return this.userRepository.save(user);
	}

	public User findById(Long id) {
		return this.userRepository.findById(id).get();
	}

	public void delete(Long id) {
		this.userRepository.deleteById(id);
	}

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	private void criaSeNaoExistPerfil(User user){
		if(user.getPerfil() == null){
			Perfil perfil = new Perfil();
			perfil.setNome(user.getEmail().substring(0,user.getEmail().indexOf("@")));
			perfilService.save(perfil);
			user.setPerfil(perfil);
			userRepository.save(user);
		}
	}
}
