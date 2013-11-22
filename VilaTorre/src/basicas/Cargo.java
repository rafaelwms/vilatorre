package basicas;

import java.util.List;

import javax.persistence.*;


@Entity
public class Cargo extends ObjetoGeral{
	
	@OneToMany(mappedBy="cargo")
	private List<Funcionario> funcionarios;

public Cargo(){}

public List<Funcionario> getFuncionarios() {
	return funcionarios;
}

public void setFuncionarios(List<Funcionario> funcionarios) {
	this.funcionarios = funcionarios;
}


}
