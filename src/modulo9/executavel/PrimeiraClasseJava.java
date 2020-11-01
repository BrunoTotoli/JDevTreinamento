package modulo9.executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import modulo9.classes.Aluno;
import modulo9.classes.Disciplina;
import modulo9.classes.Secretario;
import modulo9.classes_auxiliares.FuncaoAutenticacao;
import modulo9.constantes.StatusAluno;
import modulo9.exceptions.ExcecaoProcessarNota;
import modulo9.interfaces.PermitirAcesso;

public class PrimeiraClasseJava {
	public static void main(String[] args) {
		try {
			// lerArquivo();

			String login = JOptionPane.showInputDialog("Informe o login");
			String senha = JOptionPane.showInputDialog("Informe a senha");

			if (new FuncaoAutenticacao(new Secretario(login, senha)).autenticar()) {

				List<Aluno> alunos = new ArrayList<Aluno>();

				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

				for (int qtd = 1; qtd <= 1; qtd++) {

					String nome = JOptionPane.showInputDialog("Insira o nome: " + qtd);
					String idade = JOptionPane.showInputDialog("Insira a idade: ");
					// String dataNascimento = JOptionPane.showInputDialog("Insira a data de
					// nascimento: ");

					Aluno aluno1 = new Aluno(nome); // Converte String para inteiro
					aluno1.setIdade(Integer.valueOf(idade));

					for (int i = 0; i < 4; i++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Nome Disciplina " + (i + 1) + "?");
						String notaDisciplina = JOptionPane.showInputDialog("Nota Disciplina " + (i + 1) + "?");
						Disciplina disciplina = new Disciplina(nomeDisciplina, Double.parseDouble(notaDisciplina));
						aluno1.getDisciplinas().add(disciplina);
					}
					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

					if (escolha == 0) {

						int continuarRemover = 0;
						int posicao = 1;
						while (continuarRemover == 0 && !aluno1.getDisciplinas().isEmpty()) {
							String disciplina = JOptionPane.showInputDialog("Qual a disciplina 1,2,3 ou 4");
							aluno1.getDisciplinas().remove(Integer.valueOf(disciplina).intValue() - posicao);
							posicao++;
							continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja continuar removendo?");

						}
					}
					alunos.add(aluno1);
				}

				maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

				for (Aluno aluno : alunos) { /* Separei em listas */
					if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno);
					} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
						maps.get(StatusAluno.REPROVADO).add(aluno);
					} else {
						maps.get(StatusAluno.RECUPERACAO).add(aluno);
					}
				}
				System.out.println("------------------Lista Aprovados------------------");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
					System.out.println(
							"Resultado = " + aluno.getAlunoAprovado2() + " com media de = " + aluno.getMedia());
				}
				System.out.println("------------------Lista Recuperaco------------------");
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
					System.out.println(
							"Resultado = " + aluno.getAlunoAprovado2() + " com media de = " + aluno.getMedia());
				}
				System.out.println("------------------Lista Reprovados------------------");
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
					System.out.println(
							"Resultado = " + aluno.getAlunoAprovado2() + " com media de = " + aluno.getMedia());
				}

			}
			JOptionPane.showMessageDialog(null, "DENIED");
		} catch (Exception e) {
			StringBuilder saida = new StringBuilder();
			e.printStackTrace(); /* Imprime erro no console */

			System.out.println("Mensagem " + e.getMessage()); /* Mensagem do erro ou causa */

			for (int i = 0; i < e.getStackTrace().length; i++) {
				saida.append("\nClasse de erro: " + e.getStackTrace()[i].getClassName());
				saida.append("\nMetodo de erro: " + e.getStackTrace()[i].getMethodName());
				saida.append("\nLinha de erro: " + e.getStackTrace()[i].getLineNumber());
				saida.append("\nClass: " + e.getClass().getName());
			}

			JOptionPane.showMessageDialog(null, "Erro de conversao de numero" + saida.toString());
		} finally/* sempre e executado mesmo se ocorrer erros ou nao */ {
			/*
			 * sempre e usado quando se prescisa se executar um processo acontecendo erro ou
			 * nao
			 */
			JOptionPane.showMessageDialog(null, "TESTE");
		}

	}

	public static void lerArquivo() throws FileNotFoundException {

		File fil = new File("arquivo.txt");
		Scanner scanner = new Scanner(fil);

	}
}
