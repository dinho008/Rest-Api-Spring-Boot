package br.edu.atitus.api_example.services;

import br.edu.atitus.api_example.entities.UserEntity;

public class UserService {
	
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
		
		if (user.getPasswaord() == null
				|| user.getPasswaord().isEmpty()
				|| user.getPasswaord().length()< 8)
			throw new Exception("Password invalido");
		
		//TODO criar hash da senha
		
		//TODO validar permissão cadastro Admins
		
		
		//TODO enviar para a camada repository 
		return user;
		
	}

}
