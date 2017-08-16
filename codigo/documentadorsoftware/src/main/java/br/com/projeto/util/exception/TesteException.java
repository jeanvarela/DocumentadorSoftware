package br.com.projeto.util.exception;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class TesteException extends RuntimeException{

	public TesteException(FacesContext context,String componente,String mensagem){
		super();
		
		FacesMessage faceMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, null,mensagem);
		//"formLogin:senha"
		context.addMessage(componente,faceMessage);	
		context.renderResponse();
	}
}
