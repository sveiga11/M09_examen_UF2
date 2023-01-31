package Exercici2;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Bateria bateria = new Bateria(100);
        CarregarBateria carregarBateria = new CarregarBateria(bateria);
        DescarregarBeteria descarregarBeteria = new DescarregarBeteria(bateria);

        Scanner scanner = new Scanner(System.in);

        int menu = 0;

        while (menu == 0){
            String carregar = "1. CARREGAR BATERIA";
            String jugar = "2. JUGAR";
            String info = "3. INFO. BATERIA";
            String sortir = "0. SORTIR";

            System.out.println("<><><><><><><><><><><><><><><><><><><>");
            System.out.println("          MENU JOC BATERIA            ");
            System.out.println("<><><><><><><><><><><><><><><><><><><>");

            System.out.println(carregar);
            System.out.println(jugar);
            System.out.println(info);
            System.out.println(sortir);

            System.out.println();
            System.out.print("Escull la opcio desitjada: ");

            int escolliropcio = scanner.nextInt();

            if (escolliropcio == 1){

                ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
                scheduledExecutorService.scheduleWithFixedDelay(carregarBateria, 1000, 2000, TimeUnit.MILLISECONDS);

                System.out.println();
                System.out.println("Carregant bateria...");
                System.out.println("Esperi uns segons...");

                scheduledExecutorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
                scheduledExecutorService.shutdownNow();

                System.out.println();
                System.out.println("BATERIA CARREGADA AL " + bateria.getNivell() + "%" + "!!");
                System.out.println();

            }
            if (escolliropcio == 2){

                if (!bateria.carregada()){
                    System.out.println();
                    System.out.println("!ALERTA¡ NO ES POT JUGAR, HAS DE CARREGAR LA BATERIA PRIMER");
                    System.out.println();
                } else {
                    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
                    scheduledExecutorService.scheduleWithFixedDelay(descarregarBeteria, 1000, 2000, TimeUnit.MILLISECONDS);

                    System.out.println();
                    System.out.println("Jugant...");
                    System.out.println();

                    scheduledExecutorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
                    scheduledExecutorService.shutdownNow();

                    System.out.println("*************");
                    System.out.println("* GAME OVER *");
                    System.out.println("*************");
                }
            }
            if (escolliropcio == 3){

                boolean enrere = true;

                System.out.println();
                System.out.println("El nivell actual de la bateria es d'un " + bateria.getNivell());
                System.out.println();

                while (enrere){
                    System.out.print("TORNAR ENRRERE (s/n): ");
                    String click = scanner.next();

                    if (click.equals("S") || click.equals("s")){
                        break;
                    } else if (click.equals("N") || click.equals("n")){
                        System.out.println();
                        System.out.println("El nivell actual de la bateria es d'un " + bateria.getNivell());
                        System.out.println();
                    } else{
                        System.out.println();
                        System.out.println("OPCIO NO VALIDA");
                        System.out.println();
                        System.out.println("El nivell actual de la bateria es d'un " + bateria.getNivell());
                        System.out.println();
                    }

                }

            }
            if (escolliropcio == 0){
                break;
            }
            if (escolliropcio != 1 && escolliropcio != 2 && escolliropcio != 3 && escolliropcio != 0){
                System.out.println();
                System.out.println("OPCIO NO VALIDA!");
                System.out.println();
            }
        }

    }
}
