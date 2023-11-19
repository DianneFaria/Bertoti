package escola;

public class Professor {
	
	private String nome;
	private String endereco;
	private String email;
	private String cargo;

	
	public Professor(String nome, String endereco, String email, String cargo) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.cargo = cargo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void imprimirProfessor() {
		System.out.println("Nome: " +nome);
		System.out.println("Endereço: " +endereco);
		System.out.println("Email: " +email);
		System.out.println("Cargo: " +cargo);
	}


}
