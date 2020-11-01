package modulo9.threads.um;

import javax.swing.JOptionPane;

public class AulaThread {
	public static void main(String[] args) {

		Thread threadformulario = new Thread(thread1);
		threadformulario.start();
		
		new Thread() {

			public void run() { /* Executa o que queremos */
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					/*
					 * Quero executar esse envio com um tempo de parada, ou com um tempo determinado
					 */
					System.out.println("Executando uma rotina, envio de email");
				}
				/* Fim do codigo pararelo */
			};

		}.start(); /* Liga a thread que processa paralelamente */

		/* Codigo do sistema do usuario continua o fluxo de trabalho */

		System.out.println("Chegou ao fim do codigo da thread");
		/* Fluxo do sistema, cadastro de venda, um emissao de nf */
		JOptionPane.showMessageDialog(null, "Sistema continua executando para usuario");
	}

	private static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
		
			for(int i = 0; i< 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*Quero executar esse envio com um tempo de parada, ou com um tempo determinado*/
				System.out.println("Executando uma rotina, envio de formulario");
			}
			/*Fim do codigo pararelo*/
		}
		
	};
	private static Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};

}
