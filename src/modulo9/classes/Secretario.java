package modulo9.classes;

import modulo9.interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {

	private String registro;
	private String nivelCargo;
	private String experiencia;

	private String login;
	private String senha;

	public Secretario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Secretario() {
	}

	@Override
	public String toString() {
		return "Secretario [registro=" + registro + ", nivelCargo=" + nivelCargo + ", experiencia=" + experiencia
				+ ", nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + "]";
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public double salario() {
		// TODO Auto-generated method stub
		return 6000;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
