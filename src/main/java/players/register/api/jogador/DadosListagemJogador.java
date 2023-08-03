package players.register.api.jogador;

public record DadosListagemJogador(Long id, String nome, String clube, String idade, Posicao posicao) {

	public DadosListagemJogador(Jogador jogador) {
		this(jogador.getId(), jogador.getNome(), jogador.getClube(), jogador.getIdade(), jogador.getPosicao());
	}
}
