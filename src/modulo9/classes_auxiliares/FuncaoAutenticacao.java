package modulo9.classes_auxiliares;

import modulo9.interfaces.PermitirAcesso;

public class FuncaoAutenticacao {

	PermitirAcesso acesso;

	public boolean autenticar() {
		return acesso.autenticar();

	}

	public FuncaoAutenticacao(PermitirAcesso acesso) {
		this.acesso = acesso;
	}

}
