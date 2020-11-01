package modulo9.threads.dois;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImpFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread ob) {
		fila.add(ob);
	}

	@Override
	public void run() {
		Iterator iteracao = fila.iterator();
		synchronized (iteracao) { //Bloquear o acesso a esta lista por outros processos

			while (iteracao.hasNext()) { /* Enquanto conter dados na lista ira processar */

				ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();// Pega o objeto atual

				// Processar 10 mil notas fiscal
				// Gerar uma lista enorme de PDF
				// Gerar um envio em massa de email

				System.out.println("=========================");
				System.out.println(processar.getEmail());
				System.out.println(processar.getNome());
				
				iteracao.remove();

				try {
					Thread.sleep(100);// Dar um tempo para descarga de memoria
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			Thread.sleep(1000);// Processou toda a lista da um tempo para limpeza de memoria
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
