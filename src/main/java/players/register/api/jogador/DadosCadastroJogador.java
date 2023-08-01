package players.register.api.jogador;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroJogador(
		
		@NotBlank
		String nome, 
		
		@NotBlank
		String clube, 
		
		@NotBlank
		@Pattern(regexp = "\\d{2,3}")
		String camisa, 
		
		@NotBlank
		String nacionalidade, 
		
		@NotNull
		Posicao posicao,
		
		Double altura, 
		
		@NotBlank
		String mercado) {

} 
