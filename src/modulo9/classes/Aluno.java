package modulo9.classes;

import java.util.ArrayList;
import java.util.List;

import modulo9.constantes.StatusAluno;

public class Aluno extends Pessoa {

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public Aluno() {

	}

	public Aluno(String nome) {
		super.nome = nome;
	}

	public Aluno(String nome, int idade) {
		super.nome = nome;
		super.idade = idade;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", disciplinas="
				+ disciplinas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public double getMedia() {

		double somaNotas = 0;

		for (Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getNota();
		}

		return somaNotas / disciplinas.size();
	}

	public boolean getAlunoAprovado() {
		double media = this.getMedia();
		if (media >= 70) {
			return true;

		}
		return false;

	}

	public String getAlunoAprovado2() {
		double media = this.getMedia();
		if (media >= 50 && media <= 60) {
			return StatusAluno.RECUPERACAO;
		} else if (media >= 70) {
			return StatusAluno.APROVADO;
		}
		return StatusAluno.REPROVADO;

	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	@Override /* Identifica metodo sobreescrito */
	public boolean pessoaMaiorIdade() {
		return idade >= 15;
	}

	public String msgMaiorIdade() {
		return this.pessoaMaiorIdade() ? " Aluno maior idade" : " Aluno menor idade";
	}

	@Override
	public double salario() {
		// TODO Auto-generated method stub
		return 1900;
	}
}
