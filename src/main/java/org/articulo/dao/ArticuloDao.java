package org.articulo.dao;

import java.util.List;

import org.articulo.modelo.Articulo;

public interface ArticuloDao {
	
	public void addArticulo(Articulo articulo);
	public List<Articulo> listArticulo();
	public Articulo getArticuloById(Integer id);
	public void deleteArticulo(Integer id);

}
