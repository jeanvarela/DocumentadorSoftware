package br.com.sistemagerenciador.controlador.usuario;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.com.sistemagerenciador.modelo.entidade.usuario.Usuario;
import br.com.sistemagerenciador.modelo.repositorio.usuario.RepositorioUsuario;
import br.com.sistemagerenciador.util.anotacoes.RepositorioAnnotation;
import br.com.sistemagerenciador.util.interceptors.InjetaRepositorio;

@Stateless
@Interceptors(InjetaRepositorio.class)
public class ControladorUsuario implements IControladorUsuario {

	@RepositorioAnnotation
	private RepositorioUsuario repositorio;

	@Override
	public void adcionarUsuario(Usuario usuario) {
//		try {
//			repositorio.salvar(usuario);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	
}
