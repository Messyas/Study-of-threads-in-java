package ThreadContador;

import java.util.concurrent.Semaphore;

public class Conta {
    private int saldo = 0;
    private Semaphore semaforo = new Semaphore(1);

    public void realizarOperacao(char operacao, int valor, int numThread) {
        try {
            semaforo.acquire();
            if (operacao == 's') {
                saldo -= valor;
            } else if (operacao == 'd') {
                saldo += valor;
            }
            System.out.printf("Novo Saldo(%d/%s): %d\n", numThread, operacao, saldo);
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
