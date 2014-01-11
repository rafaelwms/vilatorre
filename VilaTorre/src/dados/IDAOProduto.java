package dados;

import java.util.List;

import basicas.Ingrediente;
import basicas.Produto;


public interface IDAOProduto extends IDAOGenerico<Produto>{
	
	public List<Produto> procurarProdutosPorIngrediente(Ingrediente ingrediente) throws Exception;
	
	public List<Produto> procurarProdutoPorPreco(double preco) throws Exception;
	
	public List<Produto> procurarProdutosPorCategoria(String cat) throws Exception;

}
