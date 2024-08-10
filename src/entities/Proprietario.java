package entities;

import java.util.ArrayList;

public class Proprietario extends Pessoa{
	private int brinde;
	private ArrayList<Animal> animais = new ArrayList<Animal>(); //começa com lista vazia	

// construtor para proprietario que ainda não possui animal
	public Proprietario(String nome, String cpf,  String email, Telefone telefone, int brinde) {
		super(nome, cpf, email, telefone);
		this.brinde = 0;
	}
	
//	construtor para proprietario que ja possui animal
	public Proprietario(String nome, String cpf, String email, Telefone telefone, int brinde, Animal animal) {
		super(cpf, nome, email, telefone);
		this.brinde = brinde;
		adicionarAnimal(animal);
	}

	public int getBrinde() {
		return brinde;
	}

	public void setBrinde(int brinde) {
		this.brinde = brinde;
	}

	
	public void adicionarAnimal(Animal animal) {
		this.animais.add(animal);
	}
	
	public void removerAnimal(Animal animal) {
		this.animais.remove(animal);
	}


	@Override
	public String toString() {
		return "Proprietário [brinde:" + brinde + ", animais:" + animais + ", CPF:" + getCpf() + ", Nome:"
				+ getNome() + ", Email:" + getEmail() + ", Telefone" + getTelefone() + "]";
	}
	
	

}
