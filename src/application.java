import entities.Animal;
import entities.BaseDados;
import entities.Diarista;
import entities.GerenciadorBrinde;
import entities.Proprietario;
import entities.Voluntario;

public class application {
	
	public static void main(String[] args) {
		BaseDados.createBase();  // Inicializa a base de dados
		GerenciadorBrinde.iniciarGerador();
	//adoções
    System.out.println("Listas antes da adoção:");
    System.out.println(BaseDados.printarListas());

    Proprietario p1 = BaseDados.buscarProprietario("15964853988");
    Voluntario p2 = BaseDados.buscarVoluntario("54539526844");


    Animal animal1 = BaseDados.buscarAnimal("gato");
    Animal animal2 = BaseDados.buscarAnimal("cachorro");
	
	if (p1 != null && animal1 != null) {
        BaseDados.addAdocao(p1, animal1);
         // Inicia o gerador de brindes
        
    } 
	else {
        System.out.println("Proprietário ou animal não encontrado para a adoção.");
    }
	
	//listar voluntarios
	if (p2 != null) {
		System.out.println();
	    System.out.println("Voluntários:");
	    System.out.print(p2); // Isso vai chamar o método toString() de Pessoa
	} else {
	    System.out.println("Voluntário com CPF 54539526844 não encontrado.");
	}
	
    System.out.println();
    System.out.println("Listas após adoção:");
    System.out.println(BaseDados.printarListas());
    System.out.println();

    
    //utilizando metodos da classe diarista (exercicio)
    System.out.println("Funcionários:");
    Diarista d1 = BaseDados.buscarDiarista("15748916455");
    if (d1 != null) {
    	d1.adicionarDia(10);;
            System.out.println(d1);
        } else {
            System.out.println("Diarista não encontrado.");
        }
    GerenciadorBrinde.pararGeracaoDeBrinde();
}
}