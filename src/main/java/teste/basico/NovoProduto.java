package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		Produto produto = new Produto("Monitor", 975.50);
		
		dao.openTX();
		dao.save(produto);
		dao.closeTX();
		dao.close();
		
	}
	
}
