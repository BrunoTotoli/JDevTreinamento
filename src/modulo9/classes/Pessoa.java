package modulo9.classes;

public abstract class Pessoa {
	protected String nome;
	protected int idade;
	protected String dataNascimento;

	
	public abstract double salario();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean pessoaMaiorIdade() {
		return idade >= 18;
	}

}
