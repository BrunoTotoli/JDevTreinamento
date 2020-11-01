package modulo9.executavel;

import modulo9.classes.Aluno;
import modulo9.classes.Diretor;
import modulo9.classes.Pessoa;
import modulo9.classes.Secretario;

public class TestandoClassesFilhas {
	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setNome("Bruno");
		aluno.setIdade(17);

		Diretor diretor = new Diretor();
		diretor.setDataNascimento("22/01/41");
		diretor.setTempoDirecao(0);
		diretor.setIdade(55);

		Secretario secretario = new Secretario();
		secretario.setIdade(80);
		secretario.setExperiencia("Burro");
		secretario.setIdade(18);

		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);

		System.out.println(aluno.pessoaMaiorIdade() + aluno.msgMaiorIdade());
		System.out.println(diretor.pessoaMaiorIdade());
		System.out.println(secretario.pessoaMaiorIdade());
	
		teste(aluno);
		teste(diretor);
		teste(secretario);
		
		
	}
	public static void teste(Pessoa p ) {
		System.out.println("Essa Pessoa e demais : " +p.getNome()+ " e o salario e de = "+p.salario());
	}
}
