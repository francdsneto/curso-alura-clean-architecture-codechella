package br.com.alura.codechella.domain.factories;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.domain.valueobjects.Endereco;

import java.time.LocalDate;

public class FabricaDeUsuario {
    private Usuario usuario;

    public FabricaDeUsuario comNomeCPFNascimento(String nome, String cpf, LocalDate nascimento) {
        this.usuario = new Usuario(cpf,nome,nascimento,"");
        return this;
    }

    public FabricaDeUsuario incluiEndereco(String cep, Integer numero, String complemento) {
        this.usuario.setEndereco(new Endereco(cep, numero, complemento));
        return this;
    }

    public Usuario build() {
        return this.usuario;
    }

}
