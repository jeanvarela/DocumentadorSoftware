package br.com.sistemagerenciador.modelo.repositorio.usuario;

import br.com.sistemagerenciador.modelo.entidade.usuario.Usuario;

public interface IRepositorioUsuario {

	public Usuario logar(String login, String senha);

}
