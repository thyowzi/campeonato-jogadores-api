package players.register.api.jogador;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "jogadores")
@Entity(name = "Jogador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Jogador {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String clube;
	private String camisa;
	private String nacionalidade;
	
	@Enumerated(EnumType.STRING)
	private Posicao posicao;
	private Double altura;
	private String mercado;
	
	public Jogador(DadosCadastroJogador dados) {
		this.nome = dados.nome();
		this.clube = dados.clube();
		this.camisa = dados.camisa();
		this.nacionalidade = dados.nacionalidade();
		this.posicao = dados.posicao();
		this.altura = dados.altura();
		this.mercado = dados.mercado();
	}
	
}

