package entities;
public abstract class Funcionario extends Pessoa{

	private double salario;
	private String matricula;
	
	public static double salario_base = 1320.0;
	
	public Funcionario( String nome, String cpf, String email, Telefone telefone, String matricula) {
		super(nome, cpf, email, telefone);
		this.matricula = matricula;
		calcularSalario(); //vinculação dinâmica explicita
	}
	
	public abstract void calcularSalario();

//	@Override
//	public void metodo() { 
//		// TODO Auto-generated method stub
//	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	//personalizando:
	@Override
	public String toString() {
		return super.toString() + "Salario:" + salario + ", matricula:" + matricula;
	}
}