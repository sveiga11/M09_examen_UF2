package Exercici2;

public class CarregarBateria implements Runnable {
    Bateria bateria;

    public CarregarBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    @Override
    public void run(){
        bateria.carregar();
    }
}