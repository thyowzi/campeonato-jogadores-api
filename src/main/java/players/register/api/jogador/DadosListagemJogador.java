package players.register.api.jogador;

public record DadosListagemJogador(String nome, String clube, String idade, Posicao posicao) {

	public DadosListagemJogador(Jogador jogador) {
		this(jogador.getNome(), jogador.getClube(), jogador.getIdade(), jogador.getPosicao());
	}
}
