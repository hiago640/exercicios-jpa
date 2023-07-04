package modelo.umpraum;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import modelo.basico.Entidade;

@Entity
@Table(name = "clientes")
public class Cliente implements Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	//após definicao do oneToOne em cascata, eu posso persistir o Cliente e ele persista o Assento
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(unique = true)
	private Assento assento;

	public Cliente() {
	}

	public Cliente(String nome, Assento assento) {
		this.nome = nome;
		this.assento = assento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

}
