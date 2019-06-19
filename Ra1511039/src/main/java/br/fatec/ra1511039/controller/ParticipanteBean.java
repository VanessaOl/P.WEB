package br.fatec.ra1511039.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.fatec.ra1511039.dao.ParticipanteDAO;
import br.fatec.ra1511039.dao.ParticipanteDAOHibernate;
import br.fatec.ra1511039.model.Participante;

@ManagedBean(name = "participanteBean")
@RequestScoped

public class ParticipanteBean {

	private List<SelectItem> participanteItem;
	
	private Participante participante = new Participante(); 

	private DataModel<Participante> listaParticipantes;

	@SuppressWarnings("unchecked")
	public DataModel<Participante> getListaParticipantes() {
		if (listaParticipantes == null) {
			ParticipanteDAO dao = new ParticipanteDAOHibernate();
			listaParticipantes = new ListDataModel<Participante>(dao.listar());
		}
		return listaParticipantes;
	}

	public void setListaParticipantes(DataModel<Participante> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public String novo() {
		this.participante = new Participante();
		return "publico/participante"; 
	}

	public String listagem() {
		this.participante = new Participante();
		return "publico/listagem"; 
	}

	public String salvar() {
		
		ParticipanteRN participanteRN = new ParticipanteRN();
		participanteRN.salvar(this.participante);
		return "participantesucesso"; 
	}

	public List<SelectItem> getParticipantes() {
		
		participanteItem = new ArrayList<SelectItem>();
		
		ParticipanteRN pais = new ParticipanteRN();
		List<Participante> participante2 = pais.listar();
		
		for (Participante c : participante2) {
			SelectItem selecao = new SelectItem(c.getCodigo(), c.getNome());
			participanteItem.add(selecao);
		}
		return participanteItem;
	}
}
