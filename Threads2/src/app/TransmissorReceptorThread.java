package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TransmissorReceptorThread extends Thread {
    private boolean isTransmissor;
    private List<Integer> canal;
    private List<String> valores = new ArrayList<>(Arrays.asList(
            "Stairway to Heaven - Led Zeppelin",
            "Hotel California - Eagles",
            "Bohemian Rhapsody - Queen",
            "Sweet Child o' Mine - Guns N' Roses",
            "Smells Like Teen Spirit - Nirvana"
    ));

    public TransmissorReceptorThread(boolean isTransmissor, List<Integer> canal) {
        this.isTransmissor = isTransmissor;
        this.canal = canal;
    }

    public void run() {
        Random random = new Random();
        if (isTransmissor) {
            int indice = random.nextInt(valores.size());
            canal.add(indice);
            try {
                Thread.sleep(random.nextInt(1000));
                synchronized (canal) {
                    canal.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                synchronized (canal) {
                    while (canal.isEmpty()) {
                        canal.wait();
                    }
                    int indice = canal.get(0);
                    String valor = valores.get(indice);
                    valores.remove(indice);
                    canal.clear();
                    canal.add(indice);
                    Thread.sleep(random.nextInt(1000));
                    String nomeMusica = valor.substring(0, valor.indexOf("-")).trim();
                    System.out.println("Música escolhida: " + valor);
                    System.out.println("Nome da música: " + nomeMusica);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> canal = new ArrayList<>();
        TransmissorReceptorThread transmissor = new TransmissorReceptorThread(true, canal);
        TransmissorReceptorThread receptor = new TransmissorReceptorThread(false, canal);

        transmissor.start();
        receptor.start();

        try {
            transmissor.join();
            receptor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
