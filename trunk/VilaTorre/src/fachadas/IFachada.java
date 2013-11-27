package fachadas;

import java.util.List;

import basicas.*;




public interface IFachada{
	
	//métodos pertinentes a classe Pessoa
	public void inserirPessoa(Pessoa pessoa)throws Exception;
	public void alterarPessoa(Pessoa pessoa)throws Exception;	
	public void removerPessoa(Pessoa pessoa)throws Exception;
	public List<Pessoa> consultarTodasPèssoas()throws Exception;
	public Pessoa consultarPessoaPorId(Integer id)throws Exception;
	public Pessoa logarPessoa(String login, String senha) throws Exception;
	public Pessoa verificarLogin(String login) throws Exception;
	public Pessoa verificarFone(String fone) throws Exception;
	public Pessoa verificarCpf(String cpf) throws Exception;
	public Pessoa verificarRg(String rg) throws Exception;
	
	//métodos pertinentes a classe Cliente
	public void inserirCliente(Cliente cliente)throws Exception;
	public void alterarCliente(Cliente cliente)throws Exception;	
	public void removerCliente(Cliente cliente)throws Exception;
	public List<Cliente> consultarTodosCliente()throws Exception;
	public Cliente consultarPorIdCliente(Integer id)throws Exception;
	public Cliente localizarClientePeloFone(String fone)throws Exception;	
	public List<Cliente> localizarClientePeloNome(String nome)throws Exception;
	public Cliente localizarClientePeloCpf(String cpf)throws Exception;	
	
	//metodos pertinentas a classe Funcionario
	public void inserirFuncionario(Funcionario funcionario)throws Exception;
	public void alterarFuncionario(Funcionario funcionario)throws Exception;	
	public void removerFuncionario(Funcionario funcionario)throws Exception;
	public List<Funcionario> consultarTodos()throws Exception;
	public Funcionario consultarFuncionarioPorId(Integer id)throws Exception;
	
	//metodos pertinentas a classe Cargo
	public void inserirCargo(Cargo cargo)throws Exception;
	public void alterarCargo(Cargo cargo)throws Exception;	
	public void removerCargo(Cargo cargo)throws Exception;
	public List<Cargo> consultarTodosCargo()throws Exception;
	public Cargo consultarCargoPorId(Integer id)throws Exception;
	
	//métodos pertinentes a classe usuario
	public void inserirUsuario(Usuario usuario)throws Exception;
	public void alterarUsuario(Usuario usuario)throws Exception;	
	public void removerUsuario(Usuario usuario)throws Exception;
	public List<Usuario> consultarTodosUsuario()throws Exception;
	public Usuario consultarUsuarioPorId(Integer id)throws Exception;
	
	//métodos pertinentes a classe Fornecedor
	public void inserirFornecedor(Fornecedor fornecedor)throws Exception;
	public void alterarFornecedor(Fornecedor fornecedor)throws Exception;	
	public void removerFornecedor(Fornecedor fornecedor)throws Exception;
	public List<Fornecedor> consultarTodosFornecedor()throws Exception;
	public Fornecedor consultarFornecedorPorId(Integer id)throws Exception;	
	
	//métodos pertinentes a classe MateriaPrimar
	public void inserirMateriaPrima(MateriaPrima materia)throws Exception;
	public void alterarMateriaPrima(MateriaPrima materia)throws Exception;	
	public void removerMateriaPrima(MateriaPrima materia)throws Exception;
	public List<MateriaPrima> consultarTodosMateriaPrima()throws Exception;
	public MateriaPrima consultarMateriaPrimaPorId(Integer id)throws Exception;

	//metodos pertinentes a classe Ingrediente
	public void inserirIngrediente(Ingrediente ingrediente)throws Exception;
	public void alterarIngrediente(Ingrediente ingrediente)throws Exception;	
	public void removerIngrediente(Ingrediente ingrediente)throws Exception;
	public List<Ingrediente> consultarTodosIngrediente()throws Exception;
	public Ingrediente consultarIngredientePorId(Integer id)throws Exception;
	
	//metodos pertinentes a classe Produto
	public void inserirProduto(Produto produto)throws Exception;
	public void alterarProduto(Produto produto)throws Exception;	
	public void removerProduto(Produto produto)throws Exception;
	public List<Produto> consultarTodosProduto()throws Exception;
	public Produto consultarProdutoPorId(Integer id)throws Exception;


}
