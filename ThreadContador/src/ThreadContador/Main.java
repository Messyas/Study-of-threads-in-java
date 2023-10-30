package ThreadContador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numThreads = 0;
        System.out.println("Digite o número de threads");
        numThreads = scanner.nextInt();

        Conta conta = new Conta();

        for (int i = 1; i <= numThreads; i++) {
            Thread thread = new Thread(new ContaThread(i, conta));
            thread.start();
        }
    }
}



/*
 * 
01-13
01-14
01-15
01-16
01-17
01-18
01-19
01-20
02-02
Este foi o retorno do codigo original 

------------------

Neste caso, a classe Conta é utiliza um semáforo para controlar o acesso ao saldo. 
O semáforo é inicializado com um valor de 1, o que permite que apenas uma thread acesse o 
recurso compartilhado (o saldo) por vez. Quando uma thread quer realizar uma operação de saque 
ou depósito, ela adquire o semáforo, realiza a operação no saldo e, em seguida, libera o semáforo. 
Dessa forma, garante-se que apenas uma thread por vez possa modificar o saldo, evitando condições 
de corrida e inconsistências nos resultados.

Demostracao do funcionamento do codigo:
Thread 1 - Digite o valor: 34
Novo Saldo(1/s): -34
Deseja realizar outra operação? (s/n)
s
Thread 1 - Digite a operação (s - saque, d - deposito): d
Thread 1 - Digite o valor: 60967
Novo Saldo(1/d): 60933
Deseja realizar outra operação? (s/n)
n

*/
