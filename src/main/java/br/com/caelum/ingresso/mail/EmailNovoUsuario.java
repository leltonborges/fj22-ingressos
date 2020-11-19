package br.com.caelum.ingresso.mail;

import br.com.caelum.ingresso.auth.Token;

public class EmailNovoUsuario implements Email{

	private final Token token;
	
	public EmailNovoUsuario(Token token) {
		this.token = token;
	}

	@Override
	public String getTo() {
		return token.getEmail();
	}

	@Override
	public String getBody() {
		StringBuilder sb = new StringBuilder("<html>");
		sb.append("<body>");
		sb.append("<h2> Bem Vindo <h2>");
		sb.append(String.format("Acesso o <a href=%s>link</a> para criar seu login no sistema de ingressos",
				this.makeUrl()	));
		sb.append("</body>");
		return sb.toString();
	}

	@Override
	public String getSubject() {
		return "Cadastro Sistema de Ingressos";
	}
	
	private String makeUrl() {
		return String.format("http://localhost:8080/usuario/validate?uuid=%s", this.token.getUuid());
	}
}
