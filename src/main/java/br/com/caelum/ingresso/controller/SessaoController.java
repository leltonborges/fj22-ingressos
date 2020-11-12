package br.com.caelum.ingresso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;

@Controller
public class SessaoController {

	private FilmeDao filmeDao;
	private SalaDao salaDao;
	
	@GetMapping("/admin/sessao")
	public ModelAndView form(@RequestParam Integer salaId) {
		ModelAndView modelAndView = new ModelAndView("sessao/sessao");
		
		modelAndView.addObject("sala", salaDao.findOne(salaId));
		modelAndView.addObject("filmes", filmeDao.findAll());
		
		return modelAndView;
	}
}
