package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {

	public static void main(String[] args) {

		Filme filme1 = new Filme("Star Wars Ep 4", 8.8);
		Filme filme2 = new Filme("O Fugitivo", 8.4);
		
		Ator atorA = new Ator("Harrison Ford");
		Ator atrizB = new Ator("Carrie Fisher");
		
		filme1.addAtor(atorA);
		filme1.addAtor(atrizB);
		
		filme2.addAtor(atorA);
		
		DAO<Filme> dao = new DAO<>();
		dao.openTX().save(filme1).closeTX().close();
		
	}
}


