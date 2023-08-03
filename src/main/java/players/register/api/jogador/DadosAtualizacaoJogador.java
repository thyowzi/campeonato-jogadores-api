package players.register.api.jogador;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoJogador(
		@NotNull
		Long id,
		String nome,
		String clube,
		String camisa,
		String idade,
		String mercado) {
}
