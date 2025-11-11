package br.edu.atitus.api_example.services;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.atitus.api_example.entities.UserEntity;
import br.edu.atitus.api_example.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository repository;
	private final PasswordEncoder encoder;
	
	public UserService(UserRepository repository, PasswordEncoder encoder) {
		super();
		this.repository = repository;
		this.encoder = encoder;
	}


	public UserEntity save(UserEntity user) throws Exception{
		if (user == null)
			throw new Exception("Objeto Nulo");
		if (user.getName() == null || user.getName().isEmpty())
			throw new Exception("Nome invaldio");
		user.setName(user.getName().trim());
		
		
		if (user == null)
			throw new Exception("Objeto Nulo");
		if (user.getEmail() == null || user.getEmail().isEmpty())
			throw new Exception("Nome invaldio");
		user.setEmail(user.getEmail().trim());
		
		if (user.getPassword() == null
				|| user.getPassword().isEmpty()
				|| user.getPassword().length()< 8)
			throw new Exception("Password invalido");
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		if (repository.existsByEmail(user.getEmail()))
			throw new Exception("já existe usuario cadastrado com este e-mail");
		
		
		
		repository.save(user);
		
		return user;
		
	}
	
	
}
