package entities;

public class Vendedor extends Funcionario{
	public static double comissao = 0.01;
	private double total_vendas;

	public Vendedor(String cpf, String nome, String email, Telefone telefone, String matricula) {
		super(cpf, nome, email, telefone, matricula);
	}
	
	public void computarVenda (double valorVenda) { //será usado no sistema de venda da Ong
		total_vendas+=valorVenda;
		calcularSalario();
	}

	//Para haver sobrescrita deve-se ter os conceitos de "Polimorfismo de método" e "Herança"
	//sobrescrita a partir de um método abstrato!
	@Override
	public void calcularSalario() {
		this.setSalario(salario_base+(comissao*total_vendas));
	}

	public double getTotal_vendas() {
		return total_vendas;
	}

	public void setTotal_vendas(double total_vendas) {
		this.total_vendas = total_vendas;
	}

	//personalizando:
	@Override //sobrescrita de método
	public String toString() {//personalizado
		return super.toString() + " total_vendas=" + total_vendas;
	}
}
