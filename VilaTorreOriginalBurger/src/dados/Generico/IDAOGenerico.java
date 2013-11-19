package dados.Generico;


import java.util.List;

public interface IDAOGenerico<Entidade> {

	public void inserir(Entidade entidade) throws Exception;

	public void alterar(Entidade entidade) throws Exception;

	public void remover(Entidade entidade) throws Exception;

	public Entidade consultarPorId(Integer id) throws Exception;

	public List<Entidade> consultarTodos() throws Exception;

}
