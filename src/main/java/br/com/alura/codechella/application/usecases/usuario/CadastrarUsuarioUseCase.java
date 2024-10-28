package br.com.alura.codechella.application.usecases.usuario;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

public interface CadastrarUsuarioUseCase {

    Usuario executar(Usuario usuario);
}
