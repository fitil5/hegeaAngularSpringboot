package com.grokonez.jwtauthentication.services;

import java.util.List;

import com.grokonez.jwtauthentication.model.User;

public interface IAdministracionUsuarios {
	public List<User> getUsuariosAll();
	public  User createUsuario(User usuarioEntity);
	public void deleteByUsername(String username);
	boolean existsByUsername(String username);
	public void deleteById(long id);
	//public User findByUsername(String username);
}
