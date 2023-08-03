package players.register.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import players.register.api.jogador.DadosAtualizacaoJogador;
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
	public Page<DadosListagemJogador> listar(Pageable paginacao) {
		return jogadorRepository.findAllByAtivoTrue(paginacao).map(DadosListagemJogador::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoJogador dados) {
		 var jogador = jogadorRepository.getReferenceById(dados.id());
		 jogador.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir (@PathVariable Long id) {
		var jogador = jogadorRepository.getReferenceById(id);
		jogador.excluir();
	}
	
}
