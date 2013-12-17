package negocio;

import java.util.List;

import javax.persistence.NoResultException;

import basicas.Cargo;
import basicas.Cliente;
import basicas.Estoque;
import basicas.Fornecedor;
import basicas.Fornecimento;
import basicas.Funcionario;
import basicas.Ingrediente;
import basicas.ItemPedido;
import basicas.MateriaPrima;
import basicas.Pagamento;
import basicas.Pedido;
import basicas.Pessoa;
import basicas.Produto;
import basicas.Usuario;
import dados.*;

public class NegocioComum {
	private IDAOCargo daoCargo;
	private IDAOCliente daoCliente;
	private IDAOEstoque daoEstoque;
	private IDAOFornecedor daoFornecedor;
	private IDAOFornecimento daoFornecimento;
	private IDAOFuncionario daoFuncionario;
	private IDAOIngrediente daoIngrediente;
	private IDAOItemPedido daoItemPedido;
	private IDAOMateriaPrima daoMateriaPrima;
	private IDAOPagamento daoPagamento;
	private IDAOPedido daoPedido;
	private IDAOPessoa daoPessoa;
	private IDAOProduto daoProduto;
	private IDAOUsuario daoUsuario;
	


	
	public NegocioComum() {
		this.daoCargo = new DAOCargo();
		this.daoCliente = new DAOCliente();
		this.daoEstoque = new DAOEstoque();
		this.daoFornecedor = new DAOFornecedor();
		this.daoFornecimento = new DAOFornecimento();
		this.daoFuncionario = new DAOFuncionario();
		this.daoIngrediente = new DAOIngrediente();
		this.daoItemPedido = new DAOItemPedido();
		this.daoMateriaPrima = new DAOMateriaPrima();
		this.daoPagamento = new DAOPagamento();
		this.daoPedido = new DAOPedido();
		this.daoPessoa = new DAOPessoa();
		this.daoProduto = new DAOProduto();
		this.daoUsuario = new DAOUsuario();
		

	}

	

	/*
	 * *********************************
	 * MÉTODOS REFERENTE SO CLIENTE 
	 * *********************************
	 */

	public void inserirCliente(Cliente entidade) throws Exception {
		try {
			if (daoPessoa.verificarCpf(entidade.getCpf()) != null) {
				throw new Exception("O CPF \"" + entidade.getCpf()
						+ "\" já está cadastrado.");
			}
			if (daoPessoa.verificarRg(entidade.getRg()) != null) {
				throw new Exception("O RG \"" + entidade.getRg()
						+ "\" já está cadastrado.");
			}
			if (daoCliente.verificarEmail(entidade.getEmail()) != null){
				throw new Exception("O e-mail \"" + entidade.getEmail() + "\" já está cadastrado.");
			}
			if (!entidade.getUsuario().getLogin().trim().equals("")) {
				if (daoPessoa.verificarLogin(entidade.getUsuario().getLogin()) != null){
					throw new Exception("O login \"" + entidade.getUsuario().getLogin() + "\" já está cadastrado.");
				}
			}
			if(daoPessoa.verificarFone(entidade.getFone()) != null){
				throw new Exception("O fone \"" + entidade.getFone()
						+ "\" já está cadastrado.");
			}
			
			this.daoCliente.inserir(entidade);
			
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public void alterarCliente(Cliente entidade) throws Exception {
		try {
			if (!entidade.getUsuario().getLogin().trim().equals("")) {
				this.verificarLogin(entidade.getUsuario().getLogin());
			}
		} catch (NoResultException ex) {
			daoCliente.alterar(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public void remover(Cliente entidade) throws Exception {
		try {
			daoCliente.remover(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}

	}

	public Cliente consultarPorId(Integer id) throws Exception {
		try {
			return daoCliente.consultarPorId(id);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public List<Cliente> consultarTodosClientes() throws Exception {
		try {
			return daoCliente.consultarTodos();
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public Cliente localizarClientePeloFone(String fone) throws Exception {
		try {
			return daoCliente.localizarClientePeloFone(fone);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public List<Cliente> localizarClientePeloNome(String nome) throws Exception {
		try {
			return daoCliente.localizarClientePeloNome(nome);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}
	
	public Cliente verificarEmail(String email) throws Exception {
		try{
		return daoCliente.verificarEmail(email);
			}catch (NoResultException x){
				return null;
			}			
		}

	/*
	 * **********************************
	 * MÉTODOS REFERENTES AO FUNCIONÁRIO 
	 * **********************************
	 */

	public Cliente localizarClientePeloCpf(String cpf) throws Exception {
		try {
			return daoCliente.localizarClientePeloCpf(cpf);
		} catch (NoResultException x) {
			return null;
		}
	}

	public void inserirFuncionario(Funcionario entidade) throws Exception {
		try {

			if (daoPessoa.verificarCpf(entidade.getCpf()) != null) {
				throw new Exception("O CPF \"" + entidade.getCpf()
						+ "\" já está cadastrado.");
			}
			if (daoPessoa.verificarRg(entidade.getRg()) != null) {
				throw new Exception("O RG \"" + entidade.getRg()
						+ "\" já está cadastrado.");
			}
			
			if(daoPessoa.verificarFone(entidade.getFone()) != null){
				throw new Exception("O fone \"" + entidade.getFone()
						+ "\" já está cadastrado.");
			}
			
			if (!entidade.getUsuario().getLogin().trim().equals("")) {
				if (daoPessoa.verificarLogin(entidade.getUsuario().getLogin()) != null){
					throw new Exception("O login \"" + entidade.getUsuario().getLogin() + "\" já está cadastrado.");
				}
			}
			daoFuncionario.inserir(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}

	}

	public void alterarFuncionario(Funcionario entidade) throws Exception {
		try {
			this.verificarCpf(entidade.getCpf());
			this.verificarRg(entidade.getRg());
			if (!entidade.getUsuario().getLogin().trim().equals("")) {
				this.verificarLogin(entidade.getUsuario().getLogin());
			}

			daoFuncionario.alterar(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}

	}

	public void removerFuncionario(Funcionario entidade) throws Exception {
		try {
			daoFuncionario.remover(entidade);
		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}

	}

	public List<Funcionario> consultarTodosFuncioinarios() throws Exception {
		try {
			return daoFuncionario.consultarTodos();

		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	public Funcionario consultarFuncionarioPorId(Integer id) throws Exception {

		try {
			return daoFuncionario.consultarPorId(id);

		} catch (Exception x) {
			throw new Exception(x.getMessage());
		}
	}

	/*
	 * **********************************
	 * MÉTODOS REFERENTES A PESSOA 
	 * **********************************
	 */

	public Pessoa logarPessoa(String login, String senha) throws Exception {
		try {
			return daoPessoa.logarPessoa(login, senha);
		} catch (NoResultException e) {
			return null;
		}
	}

	public Pessoa verificarFone(String fone) throws Exception {
		try {
			return daoPessoa.verificarFone(fone);
		} catch (NoResultException x) {
			return null;
		}
	}

	public Pessoa verificarCpf(String cpf) throws Exception {
		try {
			return daoPessoa.verificarCpf(cpf);
		} catch (Exception x) {
			return null;
		}
	}

	public Pessoa verificarRg(String rg) throws Exception {
		try {
			return daoPessoa.verificarRg(rg);
		} catch (Exception x) {
			return null;
		}
	}

	public Pessoa verificarLogin(String login) {
			try {
				return daoPessoa.verificarLogin(login);
			} catch (Exception e) {
				return null;
			}
	
	}
	/*
	 * **********************************
	 *   MÉTODOS REFERENTES A CARGO
	 * **********************************
	 */
	
	
	public void inserirCargo(Cargo cargo)throws Exception{
		try {
			daoCargo.inserir(cargo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void alterarCargo(Cargo cargo)throws Exception{
		try {
			daoCargo.alterar(cargo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}	
	public void removerCargo(Cargo cargo)throws Exception{
		try {
			daoCargo.remover(cargo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<Cargo> consultarTodosCargo()throws Exception{
		try {
			return daoCargo.consultarTodos();
		} catch (Exception e) {
			return null;
		}
	}
	public Cargo consultarPorIdCargo(Integer id)throws Exception{
		try {
			return daoCargo.consultarPorId(id);
		} catch (Exception e) {
			return null;
		}
	}


	/*
	 * **********************************
	 *   MÉTODOS REFERENTES A USUARIO
	 * **********************************
	 */
	
	public void inserirUsuario(Usuario usuario)throws Exception{
		try {
			daoUsuario.inserir(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void alterarUsuario(Usuario usuario)throws Exception{
		try {
			daoUsuario.alterar(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}	
	public void removerUsuario(Usuario usuario)throws Exception{
		try {
			daoUsuario.remover(usuario);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<Usuario> consultarTodosUsuario()throws Exception{
		try {
			return daoUsuario.consultarTodos();
		} catch (Exception e) {
			return null;
		}
	}
	public Usuario consultarPorIdUsuario(Integer id)throws Exception{
		try {
			return daoUsuario.consultarPorId(id);
		} catch (Exception e) {
			return null;
		}
	}
		


	/*
	 * **********************************
	 *   MÉTODOS REFERENTES A FORNECEDOR
	 * **********************************
	 */
	public void inserirFornecedor(Fornecedor fornecedor)throws Exception{
		try {
			
			if (daoPessoa.verificarCpf(fornecedor.getCpf()) != null) {
				throw new Exception("O CPF \"" + fornecedor.getCpf()
						+ "\" já está cadastrado.");
			}
			if (daoPessoa.verificarRg(fornecedor.getRg()) != null) {
				throw new Exception("O RG \"" + fornecedor.getRg()
						+ "\" já está cadastrado.");
			}
			
			if(daoPessoa.verificarFone(fornecedor.getFone()) != null){
				throw new Exception("O fone \"" + fornecedor.getFone()
						+ "\" já está cadastrado.");
			}
			
			daoFornecedor.inserir(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void alterarFornecedor(Fornecedor fornecedor)throws Exception{
		try {
			daoFornecedor.alterar(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}	
	public void removerFornecedor(Fornecedor fornecedor)throws Exception{
		try {
			daoFornecedor.remover(fornecedor);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public List<Fornecedor> consultarTodosFornecedor()throws Exception{
		try {
			return daoFornecedor.consultarTodos();
		} catch (Exception e) {
			return null;
		}
	}
	public Fornecedor consultarPorIdFornecedor(Integer id)throws Exception{
		try {
			return daoFornecedor.consultarPorId(id);
		} catch (Exception e) {
			return null;
		}
	}
		
		public List<Fornecedor> listarFornecedoresPorMateria(MateriaPrima materia) throws Exception{

			try {
				return daoFornecedor.listarFornecedoresPorProduto(materia);
			} catch (Exception e) {
				return null;
			}
		}
		
		
		
		
		/*
		 * **********************************
		 *   MÉTODOS REFERENTES A MATERIA PRIMA
		 * **********************************
		 */
		public void inserirMateriaPrima(MateriaPrima materia)throws Exception{
			try {
				boolean flag = false;
				
				List<MateriaPrima> lista = daoMateriaPrima.consultarTodos();
				
				for(MateriaPrima mat : lista){
					
					if(mat.getNome().toString().equals(materia.getNome().toString())){
						flag = true;
						break;
					}
					
				}
				if(flag == true){
					throw new Exception("Já há um registro para a matéria prima "+materia.getNome()+".");
				}else{
				daoMateriaPrima.inserir(materia);
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void alterarMateriaPrima(MateriaPrima materia)throws Exception{
			try {
				daoMateriaPrima.alterar(materia);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}	
		public void removerMateriaPrima(MateriaPrima materia)throws Exception{
			try {
				daoMateriaPrima.remover(materia);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public List<MateriaPrima> consultarTodosMateriaPrima()throws Exception{
			try {
				return daoMateriaPrima.consultarTodos();
			} catch (Exception e) {
				return null;
			}
		}
		public MateriaPrima consultarPorIdMateriaPrima(Integer id)throws Exception{
			try {
				return daoMateriaPrima.consultarPorId(id);
			} catch (Exception e) {
				return null;
			}
		}



		/*
		 * **********************************
		 *   MÉTODOS REFERENTES A INGREDIENTE
		 * **********************************
		 */
		public void inserirIngrediente(Ingrediente ingrediente)throws Exception{
			try {
				daoIngrediente.inserir(ingrediente);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void alterarIngrediente(Ingrediente ingrediente)throws Exception{
			try {
				daoIngrediente.alterar(ingrediente);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}	
		public void removerIngrediente(Ingrediente ingrediente)throws Exception{
			try {
				daoIngrediente.remover(ingrediente);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public List<Ingrediente> consultarTodosIngrediente()throws Exception{
			try {
				return daoIngrediente.consultarTodos();
			} catch (Exception e) {
				return null;
			}
		}
		public Ingrediente consultarPorIdIngrediente(Integer id)throws Exception{
			try {
				return daoIngrediente.consultarPorId(id);
			} catch (Exception e) {
				return null;
			}
		}
		
		
		/*
		 * **********************************
		 *   MÉTODOS REFERENTES A PRODUTO
		 * **********************************
		 */
		public void inserirProduto(Produto produto)throws Exception{
			try {
				daoProduto.inserir(produto);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void alterarProduto(Produto produto)throws Exception{
			try {
				daoProduto.alterar(produto);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}	
		public void removerProduto(Produto produto)throws Exception{
			try {
				daoProduto.remover(produto);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public List<Produto> consultarTodosProduto()throws Exception{
			try {
				return daoProduto.consultarTodos();
			} catch (Exception e) {
				return null;
			}
		}
		public Produto consultarPorIdProduto(Integer id)throws Exception{
			try {
				return daoProduto.consultarPorId(id);
			} catch (Exception e) {
				return null;
			}
		}
		public List<Produto> procurarProdutosPorIngrediente(Ingrediente ingrediente) throws Exception{

			try {
				return daoProduto.procurarProdutosPorIngrediente(ingrediente);
			} catch (Exception e) {
				return null;
			}
			
		}
		public List<Produto> procurarProdutoPorPreco(double preco) throws Exception{

			try {
				return daoProduto.procurarProdutoPorPreco(preco);
			} catch (Exception e) {
				return null;
			}
		
		}
		public List<Produto> procurarProdutosPorCategoria(String cat) throws Exception{			
			try {
			return daoProduto.procurarProdutosPorCategoria(cat);
		} catch (Exception e) {
			return null;
		}
			}
		
		
		/*
		 * **********************************
		 *   MÉTODOS REFERENTES A ITEMPEDIDO
		 * **********************************
		 */
		public void inserirItemPedido(ItemPedido item)throws Exception{
			try {
				daoItemPedido.inserir(item);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void alterarItemPedido(ItemPedido item)throws Exception{
			try {
				daoItemPedido.alterar(item);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}	
		public void removerItemPedido(ItemPedido item)throws Exception{
			try {
				daoItemPedido.remover(item);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public List<ItemPedido> consultarTodosItemPedido()throws Exception{
			try {
				return daoItemPedido.consultarTodos();
			} catch (Exception e) {
				return null;
			}
		}
		public ItemPedido consultarPorIdItemPedido(Integer id)throws Exception{
			try {
				return daoItemPedido.consultarPorId(id);
			} catch (Exception e) {
				return null;
			}
		}
		public List<ItemPedido> listarItemsDoPedido(Pedido pedido) throws Exception{

			try {
				return daoItemPedido.listarItemsDoPedido(pedido);
			} catch (Exception e) {
				return null;
			}
		}

		
		
		/*
		 * **********************************
		 *   MÉTODOS REFERENTES A PEDIDO
		 * **********************************
		 */
		public void inserirPedido(Pedido pedido)throws Exception{
			try {
				NegocioCalculos.calcularPedido(pedido);
				daoPedido.inserir(pedido);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void alterarPedido(Pedido pedido)throws Exception{
			try {
				
				NegocioCalculos.calcularPedido(pedido);
				
				daoPedido.alterar(pedido);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}	
		public void removerPedido(Pedido pedido)throws Exception{
			try {
				daoPedido.remover(pedido);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public List<Pedido> consultarTodosPedido()throws Exception{
			try {
				return daoPedido.consultarTodos();
			} catch (Exception e) {
				return null;
			}
		}
		public Pedido consultarPorIdPedido(Integer id)throws Exception{
			try {
				return daoPedido.consultarPorId(id);
			} catch (Exception e) {
				return null;
			}
		}
		public void removerItemPedido(Pedido pedido, ItemPedido item) throws Exception{
			try {
				daoPedido.removerItemPedido(pedido, item);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void adicionarItemPedido(Pedido pedido, ItemPedido item) throws Exception{
			
			try {
				daoPedido.adicionarItemPedido(pedido, item);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		
		/*
		 * **********************************
		 *   MÉTODOS REFERENTES A PAGAMENTO
		 * **********************************
		 */
		public void inserirPagamento(Pagamento pagamento)throws Exception{
			try {
				daoPagamento.inserir(pagamento);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void alterarPagamento(Pagamento pagamento)throws Exception{
			try {
				daoPagamento.alterar(pagamento);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}	
		public void removerPagamento(Pagamento pagamento)throws Exception{
			try {
				daoPagamento.remover(pagamento);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public List<Pagamento> consultarTodosPagamento()throws Exception{
			try {
				return daoPagamento.consultarTodos();
			} catch (Exception e) {
				return null;
			}
		}
		public Pagamento consultarPorIdPagamento(Integer id)throws Exception{
			try {
				return daoPagamento.consultarPorId(id);
			} catch (Exception e) {
				return null;
			}
		}
		
		/*
		 * **********************************
		 *   MÉTODOS REFERENTES A FORNECIMENTO
		 * **********************************
		 */
		public void inserirFornecimento(Fornecimento fornecimento)throws Exception{
			try {
				daoFornecimento.inserir(fornecimento);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void alterarFornecimento(Fornecimento fornecimento)throws Exception{
			try {
				daoFornecimento.alterar(fornecimento);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}	
		public void removerFornecimento(Fornecimento fornecimento)throws Exception{
			try {
				daoFornecimento.remover(fornecimento);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public List<Fornecimento> consultarTodosFornecimento()throws Exception{
			try {
				return daoFornecimento.consultarTodos();
			} catch (Exception e) {
				return null;
			}
		}
		public Fornecimento consultarPorIdFornecimento(Integer id)throws Exception{
			try {
				return daoFornecimento.consultarPorId(id);
			} catch (Exception e) {
				return null;
			}
		}
		
	    public List<Fornecimento> localizarFornecimentoMateria(MateriaPrima materia)throws Exception{

	    	try {
				return daoFornecimento.localizarFornecimentoMateria(materia);
			} catch (Exception e) {
				return null;
			}
	    } 
	    
		public List<Fornecimento> localizarMateriasFornecedor(Fornecedor fornecedor)throws Exception{

			try {
				return daoFornecimento.localizarMateriasFornecedor(fornecedor);
			} catch (Exception e) {
				return null;
			}
		
		} 
		public List<Fornecimento> localizarMateriasRangePreco(MateriaPrima materia, double de, double ate)throws Exception{

			try {
				return daoFornecimento.localizarMateriasRangePreco(materia, de, ate);
			} catch (Exception e) {
				return null;
			}
		
		}
		
		/*
		 * **********************************
		 *   MÉTODOS REFERENTES A ESTOQUE
		 * **********************************
		 */
		public void inserirEstoque(Estoque estoque)throws Exception{
			try {
				
				boolean flag = false;
				
				List<Estoque> lista = daoEstoque.consultarTodos();
				
				for (Estoque est : lista){
					if(est.getMateria().getId() == estoque.getMateria().getId()){
						flag = true;
						break;
					}
				}
				
				if(flag == true){
					throw new Exception("Matéria "+estoque.getMateria().getNome()+" já tem estoque registrado.");
				}else{
				daoEstoque.inserir(estoque);
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void alterarEstoque(Estoque estoque)throws Exception{
			try {
				daoEstoque.alterar(estoque);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}	
		public void removerEstoque(Estoque estoque)throws Exception{
			try {
				daoEstoque.remover(estoque);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public List<Estoque> consultarTodosEstoque()throws Exception{
			try {
				return daoEstoque.consultarTodos();
			} catch (Exception e) {
				return null;
			}
		}
		public Estoque consultarPorIdEstoque(Integer id)throws Exception{
			try {
				return daoEstoque.consultarPorId(id);
			} catch (Exception e) {
				return null;
			}
		}
	    public void deduzirEstoque(Estoque estoque, double qtd) throws Exception{
	    	try {
	    		
	    		estoque.setQuantidade((estoque.getQuantidade() - qtd));
	    		
				daoEstoque.alterar(estoque);
			} catch (Exception e) {
				
			}
	    }
		public void alimentarEstoque(Estoque estoque, double qtd) throws Exception{
			
			try {
				
				estoque.setQuantidade((estoque.getQuantidade() + qtd));
				
				daoEstoque.alterar(estoque);
			} catch (Exception e) {
				
			}
			
		}
	
		public Estoque localizarEstoqueMateria(MateriaPrima materia) throws Exception{
			
			try {
				return daoEstoque.localizarEstoqueMateria(materia);
			} catch (Exception e) {
				return null;
			}
			
		}
		
		
}
