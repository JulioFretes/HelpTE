package br.com.helpte.model;

import java.time.LocalDateTime;

public class Historico {

	private LocalDateTime dataHora;
	private String frase;
	private String traducao;
	
	public Historico () {}
	
	public Historico(LocalDateTime dataHora, String frase, String traducao) {
		super();
		this.dataHora = dataHora;
		this.frase = frase;
		this.traducao = traducao;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public String getTraducao() {
		return traducao;
	}

	public void setTraducao(String traducao) {
		this.traducao = traducao;
	}	
}
