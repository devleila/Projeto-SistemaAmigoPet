package entities;

import java.util.ArrayList;

public class Voluntario extends Pessoa{
	private ArrayList<String> diasAtuacao;

	public Voluntario(String cpf, String nome, String email, Telefone telefone, ArrayList<String> diasAtuacao) {
		super(cpf, nome, email, telefone);
		this.diasAtuacao = new ArrayList<>();
	}

	public ArrayList<String> getDiasAtuacao() {
		return diasAtuacao;
	}

	public void setDiasAtuacao(ArrayList<String> diasAtuacao) {
		this.diasAtuacao = diasAtuacao;
	}

	@Override
	public String toString() {
		return "Voluntario:" + super.toString() + "\nDias de Atuação: " + diasAtuacao;
	}




}
