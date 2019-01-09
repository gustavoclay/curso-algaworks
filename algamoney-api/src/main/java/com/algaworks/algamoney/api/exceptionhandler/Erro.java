package com.algaworks.algamoney.api.exceptionhandler;

public final class Erro {

	private String mensagemUsuario;
	private String mensagemDesenvolvedor;

	public Erro(String mensagemUsuario, String mensagemDesenvolvedor) {
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}
}
