package entities;

public class Gerente extends Funcionario {

	public Gerente(String nome, String cpf, String email, Telefone telefone, String matricula) {
		super(nome, cpf, email, telefone, matricula);
	}
	
	//Para haver sobrescrita deve-se ter os conceitos de "Polimorfismo de método" e "Herança"
	
	@Override //sobrescrita a partir de um método abstrato!
	public void calcularSalario() {
		this.setSalario(5*salario_base);
	}
	
	
//	public Double darDesconto(double valor) {
//		return valor;
//	}
}
