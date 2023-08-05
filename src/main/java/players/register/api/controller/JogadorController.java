package players.register.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import players.register.api.jogador.DadosAtualizacaoJogador;
import players.register.api.jogador.DadosCadastroJogador;
import players.register.api.jogador.DadosDetalhamentoJogador;
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
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroJogador dados, UriComponentsBuilder uriBuilder) {
		var jogador = new Jogador(dados);
		jogadorRepository.save(jogador);
		
		var uri =  uriBuilder.path("/jogadores/{id}").buildAndExpand(jogador.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoJogador(jogador));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemJogador>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		var page = jogadorRepository.findAllByAtivoTrue(paginacao).map(DadosListagemJogador::new);
		return ResponseEntity.ok(page);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoJogador dados) {
		 var jogador = jogadorRepository.getReferenceById(dados.id());
		 jogador.atualizarInformacoes(dados);
		 
		 return ResponseEntity.ok(new DadosDetalhamentoJogador(jogador));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir (@PathVariable Long id) {
		var jogador = jogadorRepository.getReferenceById(id);
		jogador.excluir();
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detalhar (@PathVariable Long id) {
		var jogador = jogadorRepository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoJogador(jogador));
	}
	
}
