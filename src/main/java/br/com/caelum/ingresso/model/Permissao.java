package br.com.caelum.ingresso.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

public enum Permissao implements GrantedAuthority {
	CLIENT(1, "ROLE_COMPRADOR"), SUPERVISOR(2, "ROLE_SUPERVISOR"), GERENTE(3, "ROLE_GERENTE"), ADMIN(4, "ROLE_ADMIN");

	private Integer code;
	private String nome;

	private Permissao(Integer code, String nome) {
		this.code = code;
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}

	public Integer getCode() {
		return code;
	}

	public String getNome() {
		return nome;
	}

	public static Permissao toPermisao(Integer code) {
		for (Permissao p : Permissao.values()) {
			if (p.getCode().equals(code)) {
				return p;
			}
		}
		throw new IllegalArgumentException("Code não encontrodo " + code);
	}

	public static Set<Permissao> listaPermissoes(Set<Integer> codes) {
		Set<Permissao> list = new HashSet<Permissao>();
		for (Integer i : codes) {
			list.add(toPermisao(i));
		}
		return list;
	}
}
