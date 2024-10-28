package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.usuario.CadastrarUsuarioUseCase;
import br.com.alura.codechella.application.usecases.usuario.CadastrarUsuarioUseCaseImpl;
import br.com.alura.codechella.application.usecases.usuario.ListarUsuariosUseCase;
import br.com.alura.codechella.application.usecases.usuario.ListarUsuariosUseCaseImpl;
import br.com.alura.codechella.infra.gateways.usuario.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.usuario.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.usuario.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public UsuarioEntityMapper usuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }

    @Bean
    public RepositorioDeUsuario repositorioDeUsuario(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper) {
        return new RepositorioDeUsuarioJpa(usuarioRepository, usuarioEntityMapper);
    }

    @Bean
    public CadastrarUsuarioUseCase cadastrarUsuarioUseCase(RepositorioDeUsuario repositorioDeUsuario) {
        return new CadastrarUsuarioUseCaseImpl(repositorioDeUsuario);
    }

    @Bean
    public ListarUsuariosUseCase listarUsuariosUseCase(RepositorioDeUsuario repositorioDeUsuario) {
        return new ListarUsuariosUseCaseImpl(repositorioDeUsuario);
    }

}
