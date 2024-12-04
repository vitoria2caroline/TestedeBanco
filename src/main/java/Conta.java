import java.util.Random;
import java.util.Scanner;
public class Conta {

        int numero_conta;
        String titular_conta;
        double saldo;
        double Codigo_boleto;
        Scanner entrada = new Scanner(System.in);

        public Conta(String nome_titular, double saldo_inicial) {
            this.titular_conta = nome_titular;
            this.saldo = saldo_inicial;

            Random gerador_numero = new Random();
            numero_conta = gerador_numero.nextInt(1000); // gerador randomico de números (class random)

        }

        public void VerSaldo() {
            System.out.println("O número da conta é:" + numero_conta);
            System.out.println("O nome do titular é:" + titular_conta);
            System.out.println("O saldo da conta é:" + saldo);
        }

        public void Saque(double valor_saque) {
            if (saldo >= valor_saque) {
                this.saldo = saldo - valor_saque;
                System.out.println("seu saldo atual é de:" + saldo);
            } else {
                System.out.println("saldo insulficiente");
            }
        }

        public void Deposito(double valor_deposito) {
            if (valor_deposito <= 0) {
                System.out.println("deposito invalido!");
            } else {
                this.saldo = saldo + valor_deposito;
                System.out.println("deposito realizado com sucesso!");
                System.out.println("seu saldo agora é de: " + saldo);
            }
        }

        public void Imprestimo(double valor_imprestimo) {
            if (valor_imprestimo <= saldo) {
                saldo += valor_imprestimo;
                System.out.println("emprestimo de" + valor_imprestimo);
                System.out.println("seu saldo agora e de:" + saldo);
            } else {
                System.out.println("emprestimo não concedido! valor solicitado é maior que o saldo disponível.");
            }
        }

        public void PagarBoleto(double valor_boleto) {
            if (saldo >= valor_boleto) {
                this.saldo = saldo - valor_boleto;
                System.out.println("boleto pago no valor de:" + valor_boleto);
                System.out.println("digite o codigo do boleto:" + Codigo_boleto);
                System.out.println("seu saldo atual é de " + saldo);// gerador randomico de números (class random)

            }else {
                System.out.println("salso insuficiente!");
            }
        }

        public void Iniciar() {
            int opcao;
            do {
                Exibir_menu();
                opcao = entrada.nextInt();
                Escolher_funcao(opcao);
            } while (opcao != 6);
        }

        public void Exibir_menu() {
            System.out.println("bem vindo ao banco Vouvi");
            System.out.println("escolha sua opção");
            System.out.println("1 - ver Saldo");
            System.out.println("2- sacar");
            System.out.println("3- depositar");
            System.out.println("4 Solicitar Empréstimo");
            System.out.println("5- Pagar Boleto");
            System.out.println("6- finalizar");
        }

        public void Escolher_funcao(int opcao) {
            double saque;
            double deposito;
            double imprestimo;
            double valor_boleto;

            switch (opcao) {
                case 1:
                    VerSaldo();
                    break;
                case 2:
                    System.out.println("digite o valor a ser sacado:");
                    saque = entrada.nextDouble();
                    Saque(saque);
                    break;
                case 3:
                    System.out.println("digite o valor a ser depositado");
                    deposito = entrada.nextDouble();
                    Deposito(deposito);
                    break;
                case 4:
                    System.out.println("digite o valor do emprestimo");
                    imprestimo = entrada.nextDouble();
                    Imprestimo(imprestimo);
                    break;
                case 5: System.out.println("Digite o valor do boleto:");

                valor_boleto = entrada.nextDouble();
                    System.out.println("digite o codigo do boleto:");
                    Codigo_boleto = entrada.nextDouble();
                PagarBoleto(valor_boleto);
                    break;
                case 6:
                    System.out.println("operação finalizada");
                    break;
                default:
                    System.out.println("opção invalida");
            }
        }
}