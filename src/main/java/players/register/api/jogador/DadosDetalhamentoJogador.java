package players.register.api.jogador;

public record DadosDetalhamentoJogador(
		Long id, 
		String nome, 
		String clube, 
		String idade, 
		String camisa, 
		String nacionalidade, 
		Posicao posicao, 
		Double altura, 
		String mercado ) {
	
	public DadosDetalhamentoJogador(Jogador jogador) {
		this (jogador.getId(), jogador.getNome(), jogador.getClube(), jogador.getIdade(), jogador.getCamisa(), jogador.getNacionalidade(), jogador.getPosicao(), jogador.getAltura(), jogador.getMercado());
	}

}
