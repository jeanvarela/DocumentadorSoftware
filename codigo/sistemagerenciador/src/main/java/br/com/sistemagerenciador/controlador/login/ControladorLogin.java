package br.com.sistemagerenciador.controlador.login;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.com.sistemagerenciador.modelo.entidade.usuario.Usuario;
import br.com.sistemagerenciador.modelo.repositorio.usuario.RepositorioUsuario;
import br.com.sistemagerenciador.util.anotacoes.RepositorioAnnotation;
import br.com.sistemagerenciador.util.interceptors.InjetaRepositorio;

@Stateless
@Interceptors(InjetaRepositorio.class)
public class ControladorLogin implements IControladorLogin {

	@RepositorioAnnotation
	private RepositorioUsuario repositorioUsuario;

	@Override
	public Usuario logar(String login, String senha) {
//		List<Usuario> listaUsuarios = this.repositorioUsuario.logar(login, senha);
//		
//		if (listaUsuarios != null &&  listaUsuarios.size() > 0){
//			return listaUsuarios.get(0);
//		}
//				
//		return null;
		
		return this.repositorioUsuario.logar(login, senha);
	}
}





