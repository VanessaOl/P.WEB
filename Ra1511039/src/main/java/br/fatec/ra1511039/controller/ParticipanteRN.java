package br.fatec.ra1511039.controller;

import java.util.List;

import br.fatec.ra1511039.dao.DAOFactory;
import br.fatec.ra1511039.dao.ParticipanteDAO;
import br.fatec.ra1511039.model.Participante;

public class ParticipanteRN {
	private ParticipanteDAO participanteDAO;

	public ParticipanteRN() {
		this.participanteDAO = DAOFactory.criaParticipanteDAO();
	}

	public Participante carregar(Integer codigo) {
		return this.participanteDAO.carregar(codigo);
	}

	public void salvar(Participante participante) {
		Integer codigo = participante.getCodigo();
		if (codigo == null || codigo == 0) {
			this.participanteDAO.salvar(participante);
		} else {
			this.participanteDAO.atualizar(participante);
		}
	}

	public void excluir(Participante participante) {
		this.participanteDAO.excluir(participante);
	}	

	@SuppressWarnings("unchecked")
	public List<Participante> listar() {
		return this.participanteDAO.listar();
	}
}
