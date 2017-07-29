package br.com.sistemagerenciador.util.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

public class FacesContextProducer {

	@Produces
	@RequestScoped
	public FacesContext produceFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}