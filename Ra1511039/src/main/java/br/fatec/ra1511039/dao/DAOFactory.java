package br.fatec.ra1511039.dao;

import br.fatec.ra1511039.util.HibernateUtil;

public class DAOFactory {

	
	public static ParticipanteDAO criaParticipanteDAO() {
		ParticipanteDAOHibernate participanteDAO = new ParticipanteDAOHibernate();
		      participanteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return participanteDAO;
	}

}
