package ExemploThreads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExemploThreads {
    public static void main(String[] args) {
        System.out.println("Iniciando...");

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Executando após 3 segundos");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        ).start();

        //outra forma de fazer usando SCHEDULED
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.schedule(() -> {
            System.out.println("Executando após 3 segundos!");
        }, 3, TimeUnit.SECONDS);
        scheduler.shutdown();
    }
}
