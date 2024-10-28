package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class AlteraUsuarioUseCaseImpl implements AlteraUsuarioUseCase {


    private final RepositorioDeUsuario repositorioDeUsuario;

    public AlteraUsuarioUseCaseImpl(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    @Override
    public Usuario alteraUsuario(Usuario usuario) {
        return repositorioDeUsuario.alteraUsuario(usuario.getCpf(), usuario.getEmail());
    }
}
