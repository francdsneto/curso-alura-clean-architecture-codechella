package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.factories.FabricaDeUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    @DisplayName("Não deve criar um objeto usuário pois o cpf está inválido")
    public void naoDeveCriarObjetoUsuarioComCPFInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123123123-12", "Fulano", LocalDate.parse("1990-01-01"), "email@email.com"));
    }

    @Test
    @DisplayName("Deve criar um objeto usuário pois o cpf está válido")
    public void deveCriarObjetoUsuarioComCPFValido() {
        Assertions.assertDoesNotThrow(() -> new Usuario("123.123.123-12", "Fulano", LocalDate.parse("1990-01-01"), "email@email.com"));
    }

    @Test
    @DisplayName("Não deve criar um objeto usuário pois o email está inválido")
    public void naoDeveCriarObjetoUsuarioComEmailInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.123.123-12", "Fulano", LocalDate.parse("1990-01-01"), "emailemail.com"));
    }

    @Test
    @DisplayName("Deve criar um objeto usuário pois o e-mail está válido")
    public void deveCriarObjetoUsuarioComEmailValido() {
        Assertions.assertDoesNotThrow(() -> new Usuario("123.123.123-12", "Fulano", LocalDate.parse("1990-01-01"), "email@email.com"));
    }

    @Test
    @DisplayName("Deve criar um usuário com a fábrica")
    public void deveCriarUmUsuarioUsandoAFabrica() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCPFNascimento("Neto", "123.123.123-12", LocalDate.parse("1999-01-01")).build();

        Assertions.assertEquals("Neto", usuario.getNome());
        Assertions.assertEquals("123.123.123-12", usuario.getCpf());
        Assertions.assertEquals(LocalDate.parse("1999-01-01"), usuario.getNascimento());

        usuario = fabrica.incluiEndereco("12345-678", 40, "apto 101").build();

        Assertions.assertEquals("12345-678", usuario.getEndereco().getCep());
        Assertions.assertEquals(40, usuario.getEndereco().getNumero());
        Assertions.assertEquals("apto 101", usuario.getEndereco().getComplemento());

    }

}
