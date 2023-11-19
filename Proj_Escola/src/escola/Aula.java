package escola;

import java.util.ArrayList;
import java.util.List;

public class Aula {
	
	private String duracao;
	private Professor professor;
	private List<Aluno> lista = new ArrayList<>();
	
	
	public Aula(String duracao, Professor professor) {
		this.duracao = duracao;
		this.professor = professor;
		lista = new ArrayList<Aluno>();
	}
	
	public void adicionaAluno (Aluno aluno){
        lista.add(aluno);
    }


	 public int getTotalAlunos() {
	        return lista.size();
	    }
    
	
	public void imprimirAula() {
		
		professor.imprimirProfessor();
		System.out.println("Total de alunos na turma: " + getTotalAlunos());
		System.out.println("Alunos Matriculados: ");
        
        for(int i=0; i<lista.size();i++){
            Aluno umAluno = lista.get(i);
            System.out.println("*");
            umAluno.imprimirAluno();
        }
	}
	
}
