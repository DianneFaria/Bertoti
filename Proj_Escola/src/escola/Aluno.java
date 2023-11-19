package escola;

public class Aluno {
	
	private String nome;
	private String cpf;
	private String ra;
	private String endereco;
	private String email;
	
	
	public Aluno(String nome, String cpf, String ra, String endereco, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.ra = ra;
		this.endereco = endereco;
		this.email = email;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
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
	
	public void imprimirAluno() {
		System.out.println("Nome: " +nome);
		System.out.println("CPF: " +cpf);
		System.out.println("RA: " +ra);
		System.out.println("Endereço: " +endereco);
		System.out.println("Email: " +email);
	}
	
	

}
