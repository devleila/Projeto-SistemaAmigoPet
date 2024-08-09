package entities;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GerenciadorBrinde {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private static int brindeAtual = 0;
	private static final Random random = new Random();

	public static void iniciarGerador() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(() -> {
		brindeAtual = gerarBrinde();
		System.out.println("Novo brinde gerado: R$ " + brindeAtual);
		}, 0, 5, TimeUnit.MINUTES);
	}

	private static int gerarBrinde() {
		return random.nextInt(101);
	}

	public static int getBrindeAtual() {
        return brindeAtual;
	}

	public static void pararGeracaoDeBrinde() {
		scheduler.shutdown(); // Inicia o desligamento do agendador
        try {
            if (!scheduler.awaitTermination(1, TimeUnit.MINUTES)) {
                scheduler.shutdownNow(); // Força o encerramento se não parar em 1 minuto
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow(); // Força o encerramento se interrompido
            Thread.currentThread().interrupt();
	}
	}
}