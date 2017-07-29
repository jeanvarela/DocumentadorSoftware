package br.com.sistemagerenciador.controlador.login;

import javax.ejb.Local;

import br.com.sistemagerenciador.modelo.entidade.usuario.Usuario;

@Local
public interface IControladorLogin {

	public Usuario logar(String login, String senha);
}
