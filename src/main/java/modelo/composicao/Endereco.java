package modelo.composicao;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String lougradouro;
	private String complemento;

	public String getLougradouro() {
		return lougradouro;
	}

	public void setLougradouro(String lougradouro) {
		this.lougradouro = lougradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
