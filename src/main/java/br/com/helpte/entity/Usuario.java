package br.com.helpte.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.helpte.model.Historico;

@Document("groceryitems")
public class Usuario {

	@Id
    private String id;
	
	private String nome;
	private String email;
	private Integer idade;
	private String usuario;
	private String senha;
	private List<Historico> historicos;
	
	public Usuario () {}
	
	public Usuario(String nome, String email,Integer idade, String usuario, String senha, List<Historico> historicos) {
		super();
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.usuario = usuario;
		this.senha = senha;
		this.historicos = historicos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}	
}
