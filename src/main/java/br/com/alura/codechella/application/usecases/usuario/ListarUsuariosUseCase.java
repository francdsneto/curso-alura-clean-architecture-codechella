package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.Collection;

public interface ListarUsuariosUseCase {

    Collection<Usuario> execute();

}
