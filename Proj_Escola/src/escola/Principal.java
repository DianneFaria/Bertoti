package escola;

public class Principal {
	
	public static void main(String args[]) {
		
	Aluno aluno1 = new Aluno("Dianne", "480.818.158-48", "123456", "Rua Jardim", "dianne@gmail.com");
	Aluno aluno2 = new Aluno("João", "800.568.248-18", "654321", "Rua Perez", "joao@gmail.com");
	
	
	Professor professor = new Professor("Giuliano", "Rua Fatec", "giuliano@gmail.com", "Professor de Engenharia de Software");
	
	
	Aula aula = new Aula("2 horas", professor);

	aula.adicionaAluno(aluno1);
	aula.adicionaAluno(aluno2);
	aula.imprimirAula();
	}
}
