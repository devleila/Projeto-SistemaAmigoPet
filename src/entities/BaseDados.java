package entities;

import java.util.ArrayList;

public class BaseDados {

	private static ArrayList<Pessoa> pessoas; // polimorfirmo de objetos
	private static ArrayList<Animal> animaisDisponiveis;

	public static void createBase() { //instanciar a base:

		pessoas = new ArrayList<Pessoa>(); // instanciando as listas vazias
		animaisDisponiveis = new ArrayList<Animal>();

		inicializarBase();// Chama o método para inicializar a base

	}

	private static void inicializarBase() { // garante que a base vai ter elementos
		
		//Pessoas
		pessoas.add(new Proprietario("Leila", "15964853988", "leila@gmail.com", new Telefone(55, 83, "996235487"), 0));
		pessoas.add(new Voluntario("Vitória", "54539526844", "vitoria@gmail.com", new Telefone(55, 83, "998498236"), null));
	
		// animais disponiveis
		animaisDisponiveis.add(new Animal(null, "gato", "xeren", "vira-lata", 5, 5.0));
		animaisDisponiveis.add(new Animal(null, "cachorro", "Dora", "vira-lata", 7, 10.0));
		animaisDisponiveis.add(new Animal(null, "coelho", "alice", "Polonês", 2, 4.0));
		
		//adicionando dias de atuação do voluntario
		// Como prevenir erros do tipo ClassCastException: downcast
		if (pessoas.get(1) instanceof Voluntario) {
			((Voluntario) (pessoas.get(1))).getDiasAtuacao().add("Sábado");
			((Voluntario) (pessoas.get(1))).getDiasAtuacao().add("Domingo");
		}

//		criando um funcionario de cada tipo:
//		pessoas.add(new Gerente("Marcos", "93958492955", "Marcos@gmail.com", new Telefone(55, 87, "994856632"), 0));
		pessoas.add(new Gerente("Marcos", "24239875266", "Marcos@gmail.com", new Telefone(55, 87, "9966563226"), "GE001"));
		pessoas.add(new Vendedor("Luiz", "34628494866", "Luiz@gmail.com", new Telefone(55, 87, "9936263412"), "VE001"));
		pessoas.add(new Recepcionista("Maria", "45628717866", "Maria@gmail.com", new Telefone(55, 87, "998784948"), "RE001"));
		pessoas.add(new Diarista("José", "15748916455", "Jose@gmail.com", new Telefone(55, 87, "996254487"), "DI001", 0.0));
	}

	public static Proprietario buscarProprietario(String cpf) {
		if (cpf == null)
			return null;

		for (Pessoa pessoaCurrent : pessoas)
			if (pessoaCurrent instanceof Proprietario)
				if (pessoaCurrent.getCpf().equalsIgnoreCase(cpf)) // verificação bimométrica: isFace()
					return (Proprietario) pessoaCurrent;

		return null;
	}

	public boolean addProprietario(Proprietario proprietario) {
		if (buscarProprietario(proprietario.getCpf()) != null) {
			System.out.println("Proprietário com CPF " + proprietario.getCpf() + " já existe.");
			return false; // Proprietário já existe
		}

//		proprietarios.add(proprietario);
		System.out.println("Proprietário " + proprietario.getNome() + " adicionado com sucesso.");
		return true;
	}

	public static Animal buscarAnimal(String tipo) {
		for (Animal animal : animaisDisponiveis) {
			if (animal.getTipo().equalsIgnoreCase(tipo)) {
				return animal;
			}
		}
		return null;
	}

	public static boolean addAdocao(Proprietario proprietario, Animal animal) {
		if (proprietario == null || animal == null) {
			System.out.println("Proprietário ou animal não encontrado para a adoção.");
			return false;
		}

		if (animaisDisponiveis.contains(animal)) {
			animaisDisponiveis.remove(animal); // Remove o animal da lista de disponíveis
			proprietario.adicionarAnimal(animal); // Adiciona o animal ao proprietário
			int brinde = GerenciadorBrinde.getBrindeAtual(); // Gera um brinde e atribui ao proprietário
			proprietario.setBrinde(brinde);
			System.out.println(
					proprietario.getNome() + " adotou " + animal.getNome() + " e recebeu um brinde de R$ " + brinde);
			return true;
		} else {
			System.out.println("Animal não disponível para adoção.");
			return false;
		}
	}

	public static Voluntario buscarVoluntario(String cpf) {
		if (cpf == null)
			return null;

		for (Pessoa pessoaCurrent : pessoas)
			if (pessoaCurrent instanceof Voluntario)
				if (pessoaCurrent.getCpf().equalsIgnoreCase(cpf)) // verificação bimométrica: isFace()
					return (Voluntario) pessoaCurrent;

		return null;
	}

	public static boolean addDiaVoluntario(String dia, String cpf) {
		if (cpf == null & dia == null)
			return false;

		Voluntario voluntarioTemp = buscarVoluntario(cpf); // evitar duplicidade de código!
		if (voluntarioTemp != null)
			return voluntarioTemp.getDiasAtuacao().add(dia);
		return false;
	}
	
	public static Diarista buscarDiarista(String cpf) {
		if (cpf == null)
			return null;

		for (Pessoa pessoaCurrent : pessoas)
			if (pessoaCurrent instanceof Diarista)
				if (pessoaCurrent.getCpf().equalsIgnoreCase(cpf)) //
					return (Diarista) pessoaCurrent;

		return null;
	}
	
	public static Proprietario printarListas() {
	    System.out.println("Proprietarios:");
	    for (Pessoa pessoaCurrent : pessoas)
		if (pessoaCurrent instanceof Proprietario)
			return (Proprietario) pessoaCurrent;
//			System.out.println(Proprietario)proprietario;
	    
	    System.out.println("\nAnimais Disponíveis:");
	    for (Animal animal : animaisDisponiveis) {
	        System.out.println(animal);
	    }
		return null;
	}
}
