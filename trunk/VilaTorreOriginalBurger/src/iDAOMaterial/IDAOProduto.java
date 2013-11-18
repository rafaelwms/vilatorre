package iDAOMaterial;

import java.util.List;

import basicasMaterial.*;
import basicasMaterial.Produto.Categoria;
import dados.Generico.IDAOGenerico;

public interface IDAOProduto extends IDAOGenerico<Produto> {
	
	
	public List<Produto> procurarProdutoPelaCategoria(Categoria cat) throws Exception;
	
	public List<Produto> procurarProdutoPelaFaixaDePreco(double precoInicial, double precoFinal) throws Exception;

}
