package br.com.projeto.util.filtro;

import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FacesContextUtil{
	
	private abstract static class InnerFacesContext extends FacesContext {
		protected static void setFacesContextAsCurrentInstance(FacesContext facesContext) {
			FacesContext.setCurrentInstance(facesContext);
		}
	}
	
	public static FacesContext getFacesContext(ServletRequest request,ServletResponse response,
			                             ServletContext servletContext) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext != null)
			return facesContext;
		
		FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder
		        		                                           .getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
		LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
				                                               .getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		Lifecycle lifecycle = lifecycleFactory
				.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
		facesContext = contextFactory.getFacesContext(servletContext, request,response, lifecycle);
		InnerFacesContext.setFacesContextAsCurrentInstance(facesContext);
		UIViewRoot view = facesContext.getApplication().getViewHandler().createView(facesContext, "/projetocontatos/");
		facesContext.setViewRoot(view);
		return facesContext;
	}
}
