package br.com.helpte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.helpte.entity.Usuario;
import br.com.helpte.model.Credencial;
import br.com.helpte.model.LoginResponse;
import br.com.helpte.service.UsuarioService;
import jakarta.validation.Valid;

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:19006")
@RestController
public class UsuarioController {

	@Autowired
    private UsuarioService usuarioService;
		
	@PostMapping("/registro")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrar(usuario));
    }
  
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> get(@RequestBody @Valid Credencial credencial) {
        return ResponseEntity.ok(usuarioService.logar(credencial));
    }
	
	@GetMapping("/usuario")
	public ResponseEntity<Usuario> procurar(Usuario usuario) {
		return ResponseEntity.ok(usuarioService.findByEmail(usuario.getEmail()).get());
	}	 
  
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable String id){
    	usuarioService.deleteById(id);        
        return ResponseEntity.ok().build();
    }
    @PutMapping("/usuario")
	public ResponseEntity<Usuario> replaceUsuario(@RequestBody Usuario newUsuario) {
    	return ResponseEntity.ok(usuarioService.replace(newUsuario));
    }
}
