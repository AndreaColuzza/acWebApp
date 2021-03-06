package it.geek.ufficio.DAO;

import it.geek.ufficio.model.*;

import java.util.List;

	public interface IDAO<E,K> {
		
		public E findById(K id);
		public List<E> findAll();
		public List<E> findByExample(E e);
		public boolean insert(Utente u);
		public boolean update(Utente u);
		public boolean delete(Utente u);
		
	}
