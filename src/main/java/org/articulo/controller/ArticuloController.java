package org.articulo.controller;

import java.util.Map;

import org.articulo.modelo.Articulo;
import org.articulo.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ArticuloController {

	@Autowired
	private ArticuloService service;
	
	@RequestMapping("/index")
	public String listadoArticulo(Map<String, Object> map) {
		map.put("articulo", new Articulo());
		map.put("articuloList", service.listArticulo());
		return "articuloForm";
	}
	
	@RequestMapping(value="/articulo/add", method = RequestMethod.POST)
	public String addArticulo(@ModelAttribute Articulo articulo, BindingResult result) {
		service.addArticulo(articulo);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteArticulo(@PathVariable(value="id") Integer id) {
		service.deleteArticulo(id);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String updateArticulo(@PathVariable(value="id") int id, Model model) {
		model.addAttribute("articulo", service.getArticuloById(id));
		model.addAttribute("articuloList", service.listArticulo());
		return "articuloForm";
	}
}
