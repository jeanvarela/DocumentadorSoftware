package br.com.projeto.util.mensagens;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class MensagensUtil {
	
	public static String getMensagem(String messageId) {  
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        String mensagem = "";  
        Locale locale = facesContext.getViewRoot().getLocale();  
        ResourceBundle bundle = ResourceBundle.getBundle("mensagem.messages", locale);  
       
        try {  
        	mensagem = bundle.getString(messageId);  
        } catch (Exception e) {  
        }  
        
        return mensagem;  
    }
}
