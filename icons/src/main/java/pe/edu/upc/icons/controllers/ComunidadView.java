package pe.edu.upc.icons.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.icons.models.entities.Comunidad;
import pe.edu.upc.icons.services.ComunidadService;

@Named("dtComunidadView")
@ViewScoped
public class ComunidadView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ComunidadService comunidadService;

	private List<Comunidad> comunidades;
	
	@PostConstruct
	public void init() {
		this.loadComunidades();
	}
	
	public void loadComunidades() {
		try {
			this.comunidades = comunidadService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
	}

	public ComunidadService getComunidadService() {
		return comunidadService;
	}

	public List<Comunidad> getComunidades() {
		return comunidades;
	}
	
}
