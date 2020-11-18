package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {
	
	private Sala sala;
	private Filme filme;
	private Sessao sessao;
	
	@Before
	public void dados() {
		Sala sala = new Sala("Eldorado - IMax", new BigDecimal("22.5"));
		Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12.0"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		
		this.filme = filme;
		this.sala = sala;
		this.sessao = sessao;
	}
	
	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaDoPrecoDaSalaMaisOPrecoDoFilme() {
		BigDecimal somaDosPrecosDaSalaEFilme = this.sala.getPreco().add(this.filme.getPreco());
		Assert.assertEquals(somaDosPrecosDaSalaEFilme, this.sessao.getPreco());
	}
	
	public void garanteQueOlugarA1EstaOcupadoEOsLugaresA2A3Disponiveis() {
		Lugar a1 = new Lugar("a", 1);
		Lugar a2 = new Lugar("a", 2);
		Lugar a3 = new Lugar("a", 3);
		
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO, a1);
		
		Set<Ingresso> ingressos = Stream.of(ingresso).collect(Collectors.toSet());
		this.sessao.setIngressos(ingressos);
		
		Assert.assertFalse(sessao.isDisponivel(a1));
		Assert.assertTrue(sessao.isDisponivel(a2));
		Assert.assertTrue(sessao.isDisponivel(a3));
	}

}
