package br.com.alura.codechella.infra.gateways.usuario;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.usuario.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.usuario.UsuarioRepository;

import java.util.List;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repositorio.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Usuario alteraUsuario(String cpf, String email) {
        UsuarioEntity usuario = repositorio.findByCpf(cpf).orElseThrow();
        usuario.setEmail(email);
        return mapper.toDomain(usuario);
    }
}
