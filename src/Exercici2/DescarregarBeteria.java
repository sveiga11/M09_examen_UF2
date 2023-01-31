package Exercici2;

public class DescarregarBeteria implements Runnable {
    Bateria bateria;

    public DescarregarBeteria(Bateria bateria) {
        this.bateria = bateria;
    }

    @Override
    public void run(){
        bateria.descarregar();
    }
}
