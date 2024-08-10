package entities;

public class Diarista extends Funcionario{
	
	private static double valorDiaria = 100.0;
	private double totalDias;
	
	
	public Diarista(String nome, String cpf, String email, Telefone telefone, String matricula, double totalDias) {
		super(nome, cpf, email, telefone, matricula);
		this.totalDias = totalDias;
	}

	public void CalcularDias (double totalDias) {
		this.totalDias+=totalDias;
		calcularSalario();
	}
	
	public void adicionarDia(int dias){
//	“que adiciona um ou mais dias ao total de dias trabalhados, respectivamente!
	 this.totalDias += dias;
	    calcularSalario();
	}
	
	@Override
	public void calcularSalario() {
		this.setSalario(valorDiaria*totalDias);
	}

	@Override
	public String toString() {
		 return "Diarista"+super.toString() + " | Total Dias: " + totalDias + " | Salário: R$ " + this.getSalario();
	}

}
