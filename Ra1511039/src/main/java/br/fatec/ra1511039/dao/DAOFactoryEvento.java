package br.fatec.ra1511039.dao;

import br.fatec.ra1511039.util.HibernateUtil;

public class DAOFactoryEvento {

	
	public static EventoDAO criaEventoDAO() {
		EventoDAOHibernate eventoDAO = new EventoDAOHibernate();
			      eventoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
			return eventoDAO;
		}


}
