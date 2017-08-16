package br.com.projeto.util.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.util.constante.Constantes;

public class LoginFilter implements Filter {
 
	
         public void destroy() { 
         }
 
         public void doFilter(ServletRequest req, ServletResponse res,
                              FilterChain chain) throws IOException, ServletException {

        	 HttpServletResponse response = (HttpServletResponse) res;
        	 HttpServletRequest request = (HttpServletRequest) req;
        	 
        	 Long idUsuario = (Long)request.getSession().getAttribute(Constantes.ID_USUARIO);
        	 
        	 if (idUsuario == null  && !request.getRequestURI().endsWith("/login.xhtml")
        			                && !request.getRequestURI().endsWith("/cadastro.xhtml")
        			                && !request.getRequestURI().contains("/javax.faces.resource/")) {
        			 response.sendRedirect(request.getContextPath()	 + "/login.xhtml");
        	 } else {
        		 chain.doFilter(req, res);
        	 }
         }     
       
         public void init(FilterConfig config) throws ServletException {
         } 
}