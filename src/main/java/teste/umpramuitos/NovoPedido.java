package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Pedido pedido = new Pedido();
		Produto geladeira = new Produto("Geladeira", 2789.99);
		Produto cama = new Produto("Cama", 2300);
		
		ItemPedido itemPedido1 = new ItemPedido(2, pedido, geladeira);
		ItemPedido itemPedido2 = new ItemPedido(1, pedido, cama);
		
		dao.openTX()
			.save(geladeira)
			.save(cama)
			.save(pedido)
			.save(itemPedido1)
			.save(itemPedido2)
			.closeTX()
			.close();
		
	}
	
}
