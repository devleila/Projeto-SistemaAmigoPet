package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseDados {

	private static ArrayList<Proprietario> proprietarios;
	private static ArrayList<Animal> animaisDisponiveis;
	
//instanciar a base:
	
	public static void createBase() {
//		if (proprietarios == null) { //se a lista chamada proprietarios for nula, vai criar uma lista
//			proprietarios = new ArrayList<Proprietario>(); //if so pode ser usado dentro de um metodo
		
		proprietarios = new ArrayList<Proprietario>(); //instanciando as listas vazias
		animaisDisponiveis = new ArrayList<Animal>();
		
		inicializarBase();// Chama o método para inicializar a base
		
	}
	
	private static void inicializarBase() { //garante que a base vai ter elementos
		proprietarios.add(new Proprietario("Leila", "15964853988", "leila@gmail.com", new Telefone(55, 83, "996235487"), 0));
		proprietarios.add(new Proprietario("Vitória", "54539526844", "vitoria@gmail.com", new Telefone(55, 83, "998498236"), 0));
		proprietarios.add(new Proprietario("Gabriel", "48439455688", "gabriel@gmail.com", new Telefone(55, 83, "998645789"), 0));
		
		//animais disponiveis 
		animaisDisponiveis.add(new Animal(null, "gato", "xeren", "vira-lata", 5, 5.0));
		animaisDisponiveis.add(new Animal(null, "gato", "caco", "vira-lata", 3, 6.0));
		animaisDisponiveis.add(new Animal(null, "cachorro", "Dora", "vira-lata", 7, 10.0));
		animaisDisponiveis.add(new Animal(null, "coelho", "alice", "Polonês", 2, 4.0));
		
		
	}
	
	public static Proprietario buscarProprietario(String cpf) {
		if(cpf == null) {
			return null;
		}
		
		for (Proprietario proprietarioCurrent : proprietarios) {
			if (proprietarioCurrent.getCpf().equalsIgnoreCase(cpf)) { // Chama o método getCpf na instância proprietario
				return proprietarioCurrent;
			}
		}
		return null; // Retorna null se nenhum proprietário for encontrado
	}
		
	public boolean addProprietario(Proprietario proprietario) {
		if (buscarProprietario(proprietario.getCpf()) != null) {
			 System.out.println("Proprietário com CPF " + proprietario.getCpf() + " já existe.");
			 return false; // Proprietário já existe
		}
		
		proprietarios.add(proprietario);
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
            int brinde = GerenciadorBrinde.getBrindeAtual();  // Gera um brinde e atribui ao proprietário
            proprietario.setBrinde(brinde);
            System.out.println(proprietario.getNome() + " adotou " + animal.getNome() + " e recebeu um brinde de R$ " + brinde);
            return true;
        } else {
            System.out.println("Animal não disponível para adoção.");
            return false;
		}
	}	
	
	public static void printarListas() {
	    System.out.println("Proprietários:");
	    for (Proprietario proprietario : proprietarios) {
	        System.out.println(proprietario);
	    }

	    System.out.println("\nAnimais Disponíveis:");
	    for (Animal animal : animaisDisponiveis) {
	        System.out.println(animal);
	    }
	}
	
//	public static List<Animal> ListaAnimaisPorTipo(String tipo) {
//      return animaisDisponiveis.stream()
//              .filter(animal -> animal.getTipo().equalsIgnoreCase(tipo))
//              .collect(Collectors.toList());
//  		}
	
}
	
	