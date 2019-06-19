package br.fatec.ra1511039.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.fatec.ra1511039.dao.EventoDAO;
import br.fatec.ra1511039.dao.EventoDAOHibernate;
import br.fatec.ra1511039.model.Evento;

@ManagedBean(name = "eventoBean")
@RequestScoped

public class EventoBean {

	private Evento evento = new Evento(); 

	private DataModel<Evento> listaEventos;
	private List<SelectItem> eventoItem;

	@SuppressWarnings("unchecked")
	public DataModel<Evento> getListaEventos() {
		if (listaEventos == null) {
			EventoDAO dao = new EventoDAOHibernate();
			listaEventos = new ListDataModel<Evento>(dao.listar());
		}
		return listaEventos;
	}

	public void setListaEventos(DataModel<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public String novo() {
	this.evento = new Evento();
	/**	this.evento.setInserir(true);
		this.evento.setAlterar(true);
		this.evento.setExcluir(true);
		this.evento.setVisualizar(true);**/
		
		
		return "publico/evento"; 
	}

	public String listagemEvento() {
		this.evento = new Evento();
		return "publico/listagemevento"; 
	}

	public String salvar() {
		
		EventoRN eventoRN = new EventoRN();
		eventoRN.salvar(this.evento);
		return "eventosucesso"; 
	}
	
	public List<SelectItem> getEventos() {
		
		eventoItem = new ArrayList<SelectItem>();
	
		EventoRN pais = new EventoRN();
		List<Evento> evento2 = pais.listar();
		
		for (Evento c : evento2) {
			SelectItem selecao = new SelectItem(c.getId(), c.getNomeEvento());
			eventoItem.add(selecao);
		}
		return eventoItem;
	}


}
