package br.com.alura.codechella.infra.gateways.usuario;

import br.com.alura.codechella.application.gateways.usuario.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {

    Collection<Usuario> usuarios = new ArrayList();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return (List<Usuario>) this.usuarios;
    }

    @Override
    public Usuario alteraUsuario(String cpf, String email) {
        return null;
    }

    public void gravarEmArquivo(String nomeArquivo) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(nomeArquivo);
            writer.write(this.usuarios.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
