package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.usuario.CadastrarUsuarioUseCase;
import br.com.alura.codechella.application.usecases.usuario.ListarUsuariosUseCase;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.dtos.usuario.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final ListarUsuariosUseCase listarUsuarios;

    public UsuarioController(CadastrarUsuarioUseCase cadastrarUsuarioUseCase,
                             ListarUsuariosUseCase listarUsuarios) {
        this.cadastrarUsuarioUseCase = cadastrarUsuarioUseCase;
        this.listarUsuarios = listarUsuarios;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid UsuarioDTO dto) {
        Usuario usuario = cadastrarUsuarioUseCase.executar(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return ResponseEntity.ok(new UsuarioDTO(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail()));
    }

    @GetMapping
    public ResponseEntity<Collection<UsuarioDTO>> listar() {
        var listaDeUsuarios = listarUsuarios.execute().stream().map(usuario -> new UsuarioDTO(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail())).toList();
        return ResponseEntity.ok(listaDeUsuarios);
    }

}
