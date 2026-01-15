package Business;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

    public class Main{
        public static void main(String[] args)throws IOException, InterruptedException {

            Scanner scanner = new Scanner(System.in);


            try {
                System.out.println("""
                Bem vindo ao menu de conversão
                Tecle 1 para escolher uma moeda
                Tecle qualquer outro numero para sair
                """);

                int scannerEntrada = scanner.nextInt();
                scanner.nextLine();

                while (scannerEntrada == 1) {

                    System.out.println("Selecione a moeda base:");
                    String moedaBase = scanner.nextLine();

                    System.out.println("Selecione o valor desejado:");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Selecione a moeda para conversão:");
                    String moedaConvert = scanner.nextLine();

                    System.out.println(
                            Client.Resposta(moedaBase, valor, moedaConvert)
                    );

                    System.out.println(
                            "\nDigite 1 para fazer outra conversão ou qualquer outro número para sair:"
                    );
                    scannerEntrada = scanner.nextInt();
                    scanner.nextLine();
                }

                System.out.println("Programa encerrado.");

            } catch (InputMismatchException e) {
                System.out.println(" Erro: você digitou texto onde era esperado um número.");
            } catch (NullPointerException e) {
                System.out.println(" Erro: campo obrigatório vazio ou nulo.");
            } finally {
                scanner.close();
            }
        }

    }

