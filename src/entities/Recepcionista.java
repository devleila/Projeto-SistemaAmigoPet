package entities;

public class Recepcionista extends Funcionario{

	public Recepcionista(String cpf, String nome, String email, Telefone telefone, String matricula) {
		super(cpf, nome, email, telefone, matricula);
	}
	
	@Override //sobrescrita a partir de um método abstrato!
	public void calcularSalario() {
		this.setSalario(salario_base);
	}
}