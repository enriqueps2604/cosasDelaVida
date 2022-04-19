package org.articulo.service;

import java.util.List;

import org.articulo.dao.ArticuloDao;
import org.articulo.modelo.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ArticuloServiceImpl implements ArticuloService {
	
	@Autowired
	private ArticuloDao dao;

	@Transactional
	public void addArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		dao.addArticulo(articulo);

	}

	@Transactional
	public List<Articulo> listArticulo() {
		// TODO Auto-generated method stub
		return dao.listArticulo();
	}

	@Transactional
	public Articulo getArticuloById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getArticuloById(id);
	}

	@Transactional
	public void deleteArticulo(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteArticulo(id);

	}

}
