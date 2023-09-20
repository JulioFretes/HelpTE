package br.com.helpte.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.helpte.entity.Usuario;
import br.com.helpte.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
    @PostMapping("/usuario")
    public String save(@RequestBody Usuario usuario){
    	usuarioRepository.save(usuario);
        
        return "Added Successfully";
    }
  
    @GetMapping("/usuario/{id}")
    public Optional<Usuario> get(@PathVariable String id) {        
        return usuarioRepository.findById(id);
    }
  
    @DeleteMapping("/usuario/{id}")
    public String delete(@PathVariable String id){
    	usuarioRepository.deleteById(id);
        
        return "Deleted Successfully";
    }
	
}
