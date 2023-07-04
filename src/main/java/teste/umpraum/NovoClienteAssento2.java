package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("4D");
		Cliente cliente = new Cliente("José", assento);
		
		//após definicao do oneToOne em cascata, eu posso persistir o Cliente e ele persista o Assento
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		dao.openTX()
			.save(cliente)
			.closeTX().close();
	}
}
