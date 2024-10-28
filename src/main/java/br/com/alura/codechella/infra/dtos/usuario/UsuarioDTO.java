package br.com.alura.codechella.infra.dtos.usuario;

import java.time.LocalDate;

public record UsuarioDTO(String cpf,
                         String nome,
                         LocalDate nascimento,
                         String email) {
}
