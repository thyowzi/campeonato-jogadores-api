package players.register.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import players.register.api.jogador.DadosCadastroJogador;

@RestController
@RequestMapping("jogadores")
public class JogadorController {

	@PostMapping		  
	public void cadastrar(@RequestBody DadosCadastroJogador dados) {
		System.out.println(dados);
	}
	
}
