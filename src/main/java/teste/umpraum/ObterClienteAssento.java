package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Cliente;

public class ObterClienteAssento {

	public static void main(String[] args) {
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		Cliente cliente = dao.findById(1L);
		
		System.out.println(cliente.getAssento().getNome());
		
		dao.close();
	}
	
}
