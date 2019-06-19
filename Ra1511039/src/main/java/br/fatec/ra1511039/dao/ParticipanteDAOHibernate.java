package br.fatec.ra1511039.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.fatec.ra1511039.model.Participante;
import br.fatec.ra1511039.util.HibernateUtil;

public class ParticipanteDAOHibernate implements ParticipanteDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Participante participante) {
		try {
			this.session.getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(participante);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível inserir o contato. Erro: " + e.getMessage());
		}
	}

	public void atualizar(Participante participante) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.update(participante);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível alterar o contato. Erro: " + e.getMessage());
		}
	}

	public void excluir(Participante participante) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.delete(participante);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("Não foi possível excluir o contato. Erro: " + e.getMessage());
		}
	}

		public Participante carregar(Integer codigo) {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			return (Participante) this.session.get(Participante.class, codigo);
		}


		public List<Participante> listar() {
      
        Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Participante";
		@SuppressWarnings("unchecked")
		List<Participante> lista = session.createQuery(hql).list();
		if (lista != null) {
			return lista;
		}
		else {
			System.out.println("nao passou nada");
			return null;}
		}

}
