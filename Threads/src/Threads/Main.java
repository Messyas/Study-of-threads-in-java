import java.util.Scanner;

import Main.ThreadContador;



public class Main {
    static int contador = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numThreads = 0;
        System.out.println("Digite o numero de threads");
        numThreads = scanner.nextInt();
        for (int i = 1; i <= numThreads; i++){
            Thread thread = new Thread(new ThreadContador(i));
            thread.start();
        }
    }

    static class ThreadContador implements Runnable{
        int numThread;

        ThreadContador(int numThread){
            this.numThread = numThread;
        }
        @Override
        public void run() {
            try {
                while (contador < 20) {
                    contador++;
                    System.out.printf("%02d-%02d\n", numThread, contador);
                }
            } catch (Exception e){

            }
        }
    }
}