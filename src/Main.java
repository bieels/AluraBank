import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String nome = "Gabriel";
        String tipoDeConta = "Conta Corrente";
        double saldo = 3000.00;

        informacoes(nome, tipoDeConta, saldo);

        while (true) {
            opcoes();
            int resposta = leitura.nextInt();
            switch (resposta) {
                case 1:
                    verificarSaldo(saldo);
                    break;
                case 2:
                    saldo = depositarValor(leitura, saldo);
                    break;
                case 3:
                    saldo = sacarValor(leitura, saldo);
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar o AluraBank. Volte sempre!");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void informacoes(String nome, String tipoDeConta, double saldo) {
        System.out.printf("""
               ***************************************
               
               Olá, %s, Seja bem vindo ao AluraBank!
               Seu tipo de conta é: %s
               Seu saldo é: R$ %.2f
                
               ***************************************
                """, nome, tipoDeConta, saldo);
    }

    public static void opcoes() {
        System.out.printf("""
                    Segue as opções disponíveis:
                    1 - Ver saldo;
                    2 - Depositar Valor;
                    3 - Sacar Valor;
                    4 - Sair;
                    
                    Digite uma opção:                    
                    """);
    }

    public static void verificarSaldo(double saldo) {
        System.out.printf("""
                
                Seu saldo atual é: R$ %.2f
                
                """, saldo);
    }

    public static double depositarValor(Scanner leitura, double saldo) {
        System.out.println("Digite o valor a ser depositado:");
        double valor = leitura.nextDouble();
        saldo += valor;
        System.out.printf("""
                
                Depósito de R$ %.2f realizado com sucesso. Seu novo saldo é: R$ %.2f
                
                """, valor, saldo);
        return saldo;
    }

    public static double sacarValor(Scanner leitura, double saldo) {
        System.out.println("Digite o valor a ser sacado:");
        double valor = leitura.nextDouble();
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.printf("""
                    
                    Saque de R$ %.2f realizado com sucesso. Seu novo saldo é: R$ %.2f
                    
                    """, valor, saldo);
        }
        return saldo;
    }
}
