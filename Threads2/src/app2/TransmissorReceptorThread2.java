package app2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class TransmissorReceptorThread2 extends Thread {
    private final Object lock;
    private boolean isTransmissor;
    private List<String> listaMusicas;

    private int indiceAtual;
    private String musicaTransmissor;

    public TransmissorReceptorThread2(List<String> listaMusicas) {
        lock = new Object();
        isTransmissor = true;
        this.listaMusicas = listaMusicas;
        indiceAtual = 0;
        musicaTransmissor = null;
    }

    public void enviar(String musica) {
        synchronized (lock) {
            while (!isTransmissor) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            System.out.println("Transmissor: Enviando música " + musica);
            musicaTransmissor = musica;
            isTransmissor = false;
            lock.notify();
        }
    }

    public String receber() {
        synchronized (lock) {
            while (isTransmissor) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }

            String musicaReceptor = listaMusicas.get(indiceAtual);
            System.out.println("Receptor: Recebida música " + musicaReceptor);

            indiceAtual++;
            isTransmissor = true;
            lock.notify();

            return musicaReceptor;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (isTransmissor) {
                int indice = new Random().nextInt(listaMusicas.size());
                String musica = listaMusicas.get(indice);
                enviar(musica);
            } else {
                String musica = receber();
                // Use a música recebida conforme necessário
            }
        }
    }
}

