package entities;

public class Animal {
	private static int contadorGatos = 1;
    private static int contadorCachorros = 1;
    private static int contadorCoelhos = 1;
    
	private String id;
	private String tipo;
	private String nome;
	private String raça;
	private int idade;
	private double peso;
	
	public Animal(String id, String tipo, String nome, String raça, int idade, double peso) {
		this.tipo = tipo;
		this.nome = nome;
		this.raça = raça;
		this.idade = idade;
		this.peso = peso;
		this.id = gerarId(tipo);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	//gerar id dinamicamente:

	public static String gerarId(String tipo) {		
		String prefixo = "";
		int numero = 0;
		
		switch (tipo.toLowerCase()) {
		
        case "gato":
            prefixo = "ga";
            numero = contadorGatos++;
            break;
            
        case "cachorro":
            prefixo = "ca";
            numero = contadorCachorros++;
            break;
            
        case "coelho":
            prefixo = "co";
            numero = contadorCoelhos++;
            break;
            
        default:
            throw new IllegalArgumentException("Tipo de animal desconhecido: " + tipo);
            }
		 return String.format("%s%02d", prefixo, numero);
		}

	@Override
	public String toString() {
		return "Animal [id:" + id + ", tipo:" + tipo + ", nome:" + nome + ", raça:" + raça + ", idade:" + idade
				+ ", peso:" + peso +"]";
	}
	
}
