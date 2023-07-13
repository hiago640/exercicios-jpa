package teste.heranca;

import infra.DAO;
import modelo.heranca.Fisica;
import modelo.heranca.Juridica;

public class NovaPessoaHeranca {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Fisica pessoaFisica = new Fisica("Hiago", "Abrobrinha 0", "13351655681");
		Juridica pessoaJuridica = new Juridica("Platina Cosméticos", "Coronel Antonio Rios 1097", "0253185458844800");
		
		dao.openTX()
			.save(pessoaFisica)
			.save(pessoaJuridica)
			.closeTX()
			.close();
		
	}
}
