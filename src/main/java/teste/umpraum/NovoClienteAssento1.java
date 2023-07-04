package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("16c");
		Cliente cliente = new Cliente("Thiago", assento);
		
		DAO<Object> dao = new DAO<>();
		dao.openTX()
			.save(assento)
			.save(cliente)
			.closeTX().close();
	}
}
