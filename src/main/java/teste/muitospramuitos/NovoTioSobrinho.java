package teste.muitospramuitos;

import java.util.Arrays;

import infra.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {

		Tio tio1 = new Tio("Julio");
		Tio tio2 = new Tio("Rosangela");

		Sobrinho sobrinho1 = new Sobrinho("Bárbara");
		Sobrinho sobrinho2 = new Sobrinho("Hiago");

		sobrinho1.getTios().addAll(Arrays.asList(tio1, tio2));
		sobrinho2.getTios().addAll(Arrays.asList(tio1, tio2));

		tio1.getSobrinhos().addAll(Arrays.asList(sobrinho1, sobrinho2));
		tio2.getSobrinhos().addAll(Arrays.asList(sobrinho1, sobrinho2));

		DAO<Object> dao = new DAO<>();
		dao.openTX().save(tio1).save(tio2).save(sobrinho1).save(sobrinho2).closeTX().close();
	}
}
