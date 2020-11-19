package br.com.caelum.ingresso.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Permissao implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String nome;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Usuario_Permissao", 
		joinColumns = { @JoinColumn(name = "Permissao_Id") }, 
		inverseJoinColumns = { @JoinColumn(name = "Usuario_Id") })
	private Set<Usuario> usuarios = new HashSet<Usuario>();

	public Permissao(String nome) {
		this.nome = nome;
	}

	public Permissao() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}
}
