package entities;

import java.util.ArrayList;

public class Voluntario extends Pessoa{
	private ArrayList<String> diasAtuacao;

	public Voluntario(String cpf, String nome, String email, Telefone telefone, ArrayList<String> diasAtuacao) {
		super(cpf, nome, email, telefone);
		this.diasAtuacao = diasAtuacao;
	}

	public ArrayList<String> getDiasAtuacao() {
		return diasAtuacao;
	}

	public void setDiasAtuacao(ArrayList<String> diasAtuacao) {
		this.diasAtuacao = diasAtuacao;
	}

	//próxima aula: sobrescrita de método!
//	@Override
//	public void metodo() {
//		// TODO Auto-generated method stub
//	}
}
