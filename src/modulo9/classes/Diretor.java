package modulo9.classes;

import modulo9.interfaces.PermitirAcesso;

public class Diretor extends Pessoa implements PermitirAcesso {

	private String registroEducacao;
	private int tempoDirecao;
	private String titulacao;
	private String login;
	private String senha;

	public Diretor(String login, String senha) {

		this.login = login;
		this.senha = senha;
	}

	public Diretor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Diretor [registroEducacao=" + registroEducacao + ", tempoDirecao=" + tempoDirecao + ", titulacao="
				+ titulacao + ", nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + "]";
	}

	public String getRegistroEducacao() {
		return registroEducacao;
	}

	public void setRegistroEducacao(String registroEducacao) {
		this.registroEducacao = registroEducacao;
	}

	public int getTempoDirecao() {
		return tempoDirecao;
	}

	public void setTempoDirecao(int tempoDirecao) {
		this.tempoDirecao = tempoDirecao;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public double salario() {
		return 3900;
	}

	@Override
	public boolean autenticar(String user, String password) {
		this.login = user;
		this.senha = password;
		return autenticar();
	}

	@Override
	public boolean autenticar() {
		return login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin");
	}

}
