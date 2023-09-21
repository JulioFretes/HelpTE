package br.com.helpte.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.helpte.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
    Usuario findByUsuario(String usuario);
		
}
