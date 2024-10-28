package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class CadastrarUsuarioUseCaseImpl implements CadastrarUsuarioUseCase {

    private final RepositorioDeUsuario usuarioRepository;

    public CadastrarUsuarioUseCaseImpl(RepositorioDeUsuario usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario executar(Usuario usuario) {
        return usuarioRepository.cadastrarUsuario(usuario);
    }
}
