package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.usuario.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {

    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorio = new RepositorioDeUsuarioEmArquivo();
        repositorio.cadastrarUsuario(new Usuario("123.123.123-12", "João", LocalDate.parse("1990-01-01"), "joao@email.com"));
        repositorio.cadastrarUsuario(new Usuario("123.123.123-12", "José", LocalDate.parse("1990-01-01"), "jose@email.com"));
        repositorio.cadastrarUsuario(new Usuario("123.123.123-12", "Maria", LocalDate.parse("1990-01-01"), "maria@email.com"));
        repositorio.cadastrarUsuario(new Usuario("123.123.123-12", "Pedro", LocalDate.parse("1990-01-01"), "pedro@email.com"));

//        System.out.println(repositorio.listarTodos());

        ((RepositorioDeUsuarioEmArquivo) repositorio).gravarEmArquivo("usuarios.txt");

    }

}
