package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.Pedido;

public class ObterPedido {

	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.findById(1L);
		
		pedido.getItens().forEach(System.out::println);
		
	}
}
