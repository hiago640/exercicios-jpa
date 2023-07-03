package teste.basico;

import java.util.List;

import modelo.basico.Produto;

public class ObterProdutos {

	public static void main(String[] args) {

		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.findAll();
		
		produtos.forEach(System.out::println);
		
		dao.close();
	}

}
