package modulo9.threads.dois;

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

	private JLabel descricao = new JLabel("Time Thread 1");
	private JTextField mostraTempo = new JTextField();

	private JLabel descricao2 = new JLabel("Time Thread 2");
	private JTextField mostraTempo2 = new JTextField();

	private JButton jButton1 = new JButton("Start");
	private JButton jButton2 = new JButton("Stop");

	private Runnable thread1 = new Runnable() {

		@Override
		public void run() {
			while (true) {/* Fica sempre rodando */
				mostraTempo
						.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	};
	private Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			while (true) {/* Fica sempre rodando */
				mostraTempo2
						.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	};
	private Thread thread1Time;
	private Thread thread2Time;

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
		mostraTempo.setEditable(false);
		jPanel.add(mostraTempo, controller);

		descricao2.setPreferredSize(new Dimension(200, 25));
		controller.gridy++;
		jPanel.add(descricao2, controller);

		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		controller.gridy++;
		mostraTempo2.setEditable(false);
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

				thread1Time = new Thread(thread1);
				thread2Time = new Thread(thread2);
				thread1Time.start();
				thread2Time.start();
				jButton2.setEnabled(true);
				jButton1.setEnabled(false);

			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				thread1Time.stop();
				mostraTempo.setText(null);
				thread2Time.stop();
				mostraTempo2.setText(null);
				jButton2.setEnabled(false);
				jButton1.setEnabled(true);

			}
		});
		jButton2.setEnabled(false);

		add(jPanel, BorderLayout.WEST);
		/* Sempre sera o ultimo comando */
		setVisible(true);/* Torna a tela visivel para o usuario */
	}

}
