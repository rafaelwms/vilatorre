package dados;

import basicas.Pessoa;


public interface IDAOPessoa extends IDAOGenerico<Pessoa> {

	public Pessoa logarPessoa(String login, String senha) throws Exception;

	public Pessoa verificarLogin(String login) throws Exception;
	
	public Pessoa verificarFone(String fone) throws Exception;
	
	public Pessoa verificarCpf(String cpf) throws Exception;
	
	public Pessoa verificarRg(String rg) throws Exception;
	


}
