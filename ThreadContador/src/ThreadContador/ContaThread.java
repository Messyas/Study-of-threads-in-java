package ThreadContador;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class ContaThread implements Runnable {
    private int numThread;
    private Conta conta;

    public ContaThread(int numThread, Conta conta) {
        this.numThread = numThread;
        this.conta = conta;
    }

    @Override
    public void run() {
        char operacao;
        int valor;
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.printf("Thread %d - Digite a operação (s - saque, d - deposito): ", numThread);
            operacao = scanner.next().charAt(0);
            System.out.printf("Thread %d - Digite o valor: ", numThread);
            valor = scanner.nextInt();

            conta.realizarOperacao(operacao, valor, numThread);

            System.out.println("Deseja realizar outra operação? (s/n)");
            char resposta = scanner.next().charAt(0);
            if (resposta != 's') {
                continuar = false;
            }
        }
    }
}
