package org.articulo.dao;

import java.util.List;

import org.articulo.modelo.Articulo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ArticuloDaoImpl implements ArticuloDao {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(articulo);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: "+e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Articulo> listArticulo() {
		// TODO Auto-generated method stub
		List<Articulo> list = null;
		try {
			list = (List<Articulo>) sessionFactory.getCurrentSession().createQuery("from Articulo").list();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: "+e.getMessage());
		}
		return list;
	}

	
	@Override
	public Articulo getArticuloById(Integer id) {
		// TODO Auto-generated method stub
		Articulo articulo = null;
		try {
			articulo = (Articulo) sessionFactory.getCurrentSession().get(Articulo.class, id);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: "+e.getMessage());
		}
		return articulo;

		
	}

	@Override
	public void deleteArticulo(Integer id) {
		// TODO Auto-generated method stub
		Articulo articulo = null;
		try {
			articulo = (Articulo) sessionFactory.getCurrentSession().load(Articulo.class, id);
			sessionFactory.getCurrentSession().delete(articulo);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: "+e.getMessage());
		}
		
	}

}
