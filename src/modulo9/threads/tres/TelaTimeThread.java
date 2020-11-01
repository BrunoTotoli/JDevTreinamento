package modulo9.threads.tres;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {

	private JPanel jPanel = new JPanel(new GridBagLayout()); /* Painel de componentes */

	private JLabel descricao = new JLabel("Nome");
	private JTextField mostraTempo = new JTextField();

	private JLabel descricao2 = new JLabel("E-mail");
	private JTextField mostraTempo2 = new JTextField();

	private JButton jButton1 = new JButton("Add-Lista");
	private JButton jButton2 = new JButton("Stop");

	private ImpFilaThread fila = new ImpFilaThread();

	public TelaTimeThread() {
		setTitle("Timer com Thread");/* Nome da janela */
		setSize(new Dimension(240, 240));/* Pixeis de altura e largura */
		setResizable(false) /* Nao deixa aumentar ou diminuir a tela */;
		setLocationRelativeTo(null); /* Centraliza na tela */

		GridBagConstraints controller = new GridBagConstraints(); /* Controlador de posicionamento de componentes */
		controller.gridx = 0;
		controller.gridy = 0;
		controller.gridwidth = 2;
		controller.insets = new Insets(5, 10, 5, 5);
		controller.anchor = GridBagConstraints.WEST;

		descricao.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricao, controller);

		controller.gridy++;
		mostraTempo.setPreferredSize(new Dimension(200, 25));
		jPanel.add(mostraTempo, controller);

		descricao2.setPreferredSize(new Dimension(200, 25));
		controller.gridy++;
		jPanel.add(descricao2, controller);

		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		controller.gridy++;
		jPanel.add(mostraTempo2, controller);

		controller.gridwidth = 1;

		jButton1.setPreferredSize(new Dimension(92, 25));
		controller.gridy++;
		jPanel.add(jButton1, controller);

		jButton2.setPreferredSize(new Dimension(92, 25));
		controller.gridx++;
		jPanel.add(jButton2, controller);

		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(fila == null) {
					fila = new ImpFilaThread();
					fila.start();
				}
				for (int qtd = 0; qtd < 100; qtd++) {
					ObjetoFilaThread obj = new ObjetoFilaThread();
					obj.setNome(mostraTempo.getText());
					obj.setEmail(mostraTempo2.getText() +qtd);

					fila.add(obj);
				}

			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fila.stop();
				fila = null;
			}
		});

		fila.start();
		add(jPanel, BorderLayout.WEST);
		/* Sempre sera o ultimo comando */
		setVisible(true);/* Torna a tela visivel para o usuario */
	}

}
