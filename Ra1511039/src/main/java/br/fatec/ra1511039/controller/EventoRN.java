package br.fatec.ra1511039.controller;

import java.util.List;

import br.fatec.ra1511039.dao.DAOFactoryEvento;
import br.fatec.ra1511039.dao.EventoDAO;
import br.fatec.ra1511039.model.Evento;

public class EventoRN {

	private EventoDAO eventoDAO;

	public EventoRN() {
		this.eventoDAO = DAOFactoryEvento.criaEventoDAO();
	}

	public Evento carregar(Integer codigo, String opcao) {
		return this.eventoDAO.carregar(codigo);
	}

	public void salvar(Evento evento) {
		Integer id = evento.getId();
		if (id == null || id == 0) {
			this.eventoDAO.salvar(evento);
		} else {
			this.eventoDAO.atualizar(evento);
		}
	}

	public void excluir(Evento evento) {
		this.eventoDAO.excluir(evento);
	}	

	@SuppressWarnings("unchecked")
	public List<Evento> listar() {
		return this.eventoDAO.listar();
	}
}
