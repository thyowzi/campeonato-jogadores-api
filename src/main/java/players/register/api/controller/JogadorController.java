package players.register.api.controller;

import java.util.List;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import players.register.api.jogador.DadosCadastroJogador;
import players.register.api.jogador.DadosListagemJogador;
import players.register.api.jogador.Jogador;
import players.register.api.jogador.JogadorRepository;

@RestController
@RequestMapping("jogadores")
public class JogadorController {

	@Autowired
	private JogadorRepository jogadorRepository;
	
	@PostMapping	
	@Transactional 						
	public void cadastrar(@RequestBody @Valid DadosCadastroJogador dados) {
		jogadorRepository.save(new Jogador(dados));
	}
	
	@GetMapping
	public List<DadosListagemJogador> listar() {
		return jogadorRepository.findAll().stream().map(DadosListagemJogador::new).toList();
	}
	
}
