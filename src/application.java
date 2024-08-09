import entities.Animal;
import entities.BaseDados;
import entities.GerenciadorBrinde;
import entities.Pessoa;
import entities.Proprietario;

public class application {
	
	public static void main(String[] args) {
		
		
		BaseDados.createBase();  // Inicializa a base de dados
		GerenciadorBrinde.iniciarGerador(); // Inicia o gerador de brindes
	
    System.out.println("Listas antes da adoção:");
    BaseDados.printarListas();
    System.out.println("_____________________________________________");

    Proprietario p1 = BaseDados.buscarProprietario("15964853988");
    Proprietario p2 = BaseDados.buscarProprietario("54539526844");
//    Pessoa pessoa = new Pessoa()

    Animal animal1 = BaseDados.buscarAnimal("gato");
    Animal animal2 = BaseDados.buscarAnimal("cachorro");
	
	if (p1 != null && animal1 != null) {
        BaseDados.addAdocao(p1, animal1);
    } else {
        System.out.println("Proprietário ou animal não encontrado para a adoção.");
    }

    if (p2 != null && animal2 != null) {
        BaseDados.addAdocao(p2, animal2);
    } else {
        System.out.println("Proprietário ou animal não encontrado para a adoção.");
    }
    
    System.out.println();
    System.out.println("Listas após adoção:");
    BaseDados.printarListas();
    
    GerenciadorBrinde.pararGeracaoDeBrinde();
//    problemas com o gerenciador
    
}
}