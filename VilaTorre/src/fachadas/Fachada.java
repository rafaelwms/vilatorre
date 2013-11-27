package fachadas;

import java.util.List;

import negocio.NegocioComum;

import basicas.*;

public class Fachada implements IFachada {

	private static IFachada fachada;
	private  NegocioComum negocioComum;

	private Fachada() {
		this.negocioComum = new NegocioComum();
	}

	public static IFachada getInstancia() {
		if (fachada == null) {
			fachada = new Fachada();
		}
		return fachada;
	}

	@Override
	public void inserirCliente(Cliente cliente) throws Exception {	
				negocioComum.inserirCliente(cliente);	
	}

	@Override
	public void alterarCliente(Cliente cliente) throws Exception {	
			negocioComum.alterarCliente(cliente);	
	}
	
	@Override
	public void removerCliente(Cliente cliente) throws Exception {	
			negocioComum.remover(cliente);	
	}

	@Override
	public List<Cliente> consultarTodosCliente() throws Exception {
			return negocioComum.consultarTodosClientes();
	}

	public Cliente consultarPorIdCliente(Integer id) throws Exception {
			return negocioComum.consultarPorId(id);
	}

	@Override
	public Cliente localizarClientePeloFone(String fone) throws Exception {
		return negocioComum.localizarClientePeloFone(fone);
	}

	@Override
	public List<Cliente> localizarClientePeloNome(String nome) throws Exception {
		return negocioComum.localizarClientePeloNome(nome);
	}

	@Override
	public Cliente localizarClientePeloCpf(String cpf) throws Exception {
		return negocioComum.localizarClientePeloCpf(cpf);
	}

	@Override
	public void inserirFuncionario(Funcionario funcionario) throws Exception {
		negocioComum.inserirFuncionario(funcionario);
	}

	@Override
	public void alterarFuncionario(Funcionario funcionario) throws Exception {
		negocioComum.alterarFuncionario(funcionario);
	}

	@Override
	public void removerFuncionario(Funcionario funcionario) throws Exception {
		negocioComum.removerFuncionario(funcionario);
	}

	@Override
	public List<Funcionario> consultarTodos() throws Exception {
		return negocioComum.consultarTodosFuncioinarios();
	}

	@Override
	public Funcionario consultarFuncionarioPorId(Integer id) throws Exception {
		return negocioComum.consultarFuncionarioPorId(id);
	}

	@Override
	public void inserirPessoa(Pessoa pessoa) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterarPessoa(Pessoa pessoa) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void removerPessoa(Pessoa pessoa) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Pessoa> consultarTodasPèssoas() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa consultarPessoaPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa logarPessoa(String login, String senha) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.logarPessoa(login, senha);
	}

	@Override
	public Pessoa verificarLogin(String login) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.verificarLogin(login);
	}

	@Override
	public Pessoa verificarFone(String fone) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.verificarFone(fone);
	}

	@Override
	public Pessoa verificarCpf(String cpf) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.verificarCpf(cpf);
	}

	@Override
	public Pessoa verificarRg(String rg) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.verificarRg(rg);
	}

	@Override
	public void inserirCargo(Cargo cargo) throws Exception {
		// TODO Auto-generated method stub
		negocioComum.inserirCargo(cargo);
	}

	@Override
	public void alterarCargo(Cargo cargo) throws Exception {
		// TODO Auto-generated method stub
		negocioComum.alterarCargo(cargo);
	}

	@Override
	public void removerCargo(Cargo cargo) throws Exception {
		// TODO Auto-generated method stub
		negocioComum.removerCargo(cargo);
	}

	@Override
	public List<Cargo> consultarTodosCargo() throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.consultarTodosCargo();
	}

	@Override
	public Cargo consultarCargoPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return negocioComum.consultarPorIdCargo(id);
	}

	@Override
	public void inserirUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> consultarTodosUsuario() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario consultarUsuarioPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirFornecedor(Fornecedor fornecedor) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarFornecedor(Fornecedor fornecedor) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerFornecedor(Fornecedor fornecedor) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fornecedor> consultarTodosFornecedor() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fornecedor consultarFornecedorPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> listarFornecedoresPorProduto(MateriaPrima materia)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirMateriaPrima(MateriaPrima materia) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarMateriaPrima(MateriaPrima materia) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerMateriaPrima(MateriaPrima materia) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MateriaPrima> consultarTodosMateriaPrima() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MateriaPrima consultarMateriaPrimaPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirIngrediente(Ingrediente ingrediente) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarIngrediente(Ingrediente ingrediente) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerIngrediente(Ingrediente ingrediente) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ingrediente> consultarTodosIngrediente() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingrediente consultarIngredientePorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirProduto(Produto produto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarProduto(Produto produto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerProduto(Produto produto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> consultarTodosProduto() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto consultarProdutoPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> procurarProdutosPorIngrediente(Ingrediente ingrediente)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> procurarProdutoPorPreco(double preco) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> procurarProdutosPorCategoria(String cat)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirItemPedido(ItemPedido item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarItemPedido(ItemPedido item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerItemPedido(ItemPedido item) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ItemPedido> consultarTodosItemPedido() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemPedido consultarItemPedidoPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemPedido> listarItemsDoPedido(Pedido pedido) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirPedido(Pedido pedido) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarPedido(Pedido pedido) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerPedido(Pedido pedido) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> consultarTodosPedido() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido consultarPedidoPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerItemPedido(Pedido pedido, ItemPedido item)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarItemPedido(Pedido pedido, ItemPedido item)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserirPagamento(Pagamento pagamento) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarPagamento(Pagamento pagamento) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerPagamento(Pagamento pagamento) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pagamento> consultarTodosPagamento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pagamento consultarPagamentoPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirFornecimento(Fornecimento fornecimento) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarFornecimento(Fornecimento fornecimento) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerFornecimento(Fornecimento fornecimento) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fornecimento> consultarTodosFornecimento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fornecimento consultarFornecimentoPorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecimento> localizarFornecimentoMateria(MateriaPrima materia)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecimento> localizarMateriasFornecedor(Fornecedor fornecedor)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecimento> localizarMateriasRangePreco(MateriaPrima materia,
			double de, double ate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirEstoque(Estoque estoque) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarEstoque(Estoque estoque) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerEstoque(Estoque estoque) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Estoque> consultarTodosEstoque() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estoque consultarEstoquePorId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deduzirEstoque(MateriaPrima mat, double qtd) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alimentarEstoque(MateriaPrima mat, double qtd) throws Exception {
		// TODO Auto-generated method stub
		
	}

}