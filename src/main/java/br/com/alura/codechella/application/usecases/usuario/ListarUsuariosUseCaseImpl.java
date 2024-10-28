package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.Collection;

public class ListarUsuariosUseCaseImpl implements ListarUsuariosUseCase {

    private final RepositorioDeUsuario repositorioDeUsuario;

    public ListarUsuariosUseCaseImpl(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    @Override
    public Collection<Usuario> execute() {
        return repositorioDeUsuario.listarTodos();
    }
}
