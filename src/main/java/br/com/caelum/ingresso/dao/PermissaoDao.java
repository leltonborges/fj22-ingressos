package br.com.caelum.ingresso.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Permissao;

@Repository
public class PermissaoDao {

	@PersistenceContext
	private EntityManager manager;

	public void save(Permissao perm) {
		this.manager.persist(perm);
	}

	public void saveAll(Set<Permissao> listPermissoes) {
		for (Permissao p : listPermissoes) {
			this.manager.persist(p);
		}
	}

	public Permissao findNome(String nome) {
		return manager.createQuery("select p from Permissao p where p.nome = :nome", Permissao.class)
				.setParameter("nome", nome).getSingleResult();
	}

}
