import java.util.Scanner;
public class Desafio{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String nomeTitular;
        String tipoConta;
        double saldoBancario = 7500.00;
        double valorTransferencia;
        double valorRecebido;
        double pagarBoleto;
        int opcao = 0;

        System.out.println("*************************");
        System.out.println("****** CRYPTO JOIN ******");
        System.out.println("\n*************************");

        do{
            System.out.print("Informe o nome do titular da conta: ");
            nomeTitular = scanner.nextLine();
            if(nomeTitular.trim().isEmpty()){
                System.out.println("Nome do titular não pode estar vazio! Tente novamente.");
            }
        }while(nomeTitular.trim().isEmpty());

        do{
            System.out.print("Informe o tipo de conta: ");
            tipoConta = scanner.nextLine();
            if(!tipoConta.equalsIgnoreCase("Corrente") && !tipoConta.equalsIgnoreCase("Poupança")){
                System.out.println("Tipo de conta inválida!");
            }
        }while(!tipoConta.equalsIgnoreCase("Corrente") && !tipoConta.equalsIgnoreCase("Poupança"));


        do {
            System.out.println("Digite a sua opção: ");
            System.out.println("1 - Consultar Saldo: ");
            System.out.println("2 - Fazer pix: ");
            System.out.println("3 - Receber valor: ");
            System.out.println("4 - Pagar boleto: ");
            System.out.println("5 - Sair");

            System.out.print("Informe a opção: ");
            opcao = scanner.nextInt();
            if(opcao < 1 || opcao > 5){
                System.out.println("Opção inválida!");
            }

            switch(opcao){
                case 1:
                    System.out.println("O saldo é: " + saldoBancario);
                    System.out.println("Titular da conta: " + nomeTitular);
                    System.out.println("Tipo da conta: " + tipoConta);
                    break;

                case 2:
                    do {
                        System.out.println("Qual o valor deseja transferir?: ");
                        valorTransferencia = scanner.nextDouble();
                        if (valorTransferencia > saldoBancario) {
                            System.out.println("Não há saldo suficiente para realizar tranferência");
                        }
                    } while (valorTransferencia > saldoBancario);
                    saldoBancario -= valorTransferencia;
                    System.out.println("Transferência realizada com sucesso.");
                    System.out.println("Novo saldo: " + saldoBancario);
                    System.out.println("Titular da conta: " + nomeTitular);
                    System.out.println("Tipo da conta: " + tipoConta);
                    break;

                case 3:
                    System.out.println("Valor recebido");
                    valorRecebido = scanner.nextDouble();
                    saldoBancario += valorRecebido;
                    System.out.println("Novo saldo: " + saldoBancario);
                    System.out.println("Titular da conta: " + nomeTitular);
                    System.out.println("Tipo da conta: " + tipoConta);
                    break;

                case 4:
                    do {
                        System.out.print("Informe o valor do boleto: ");
                        pagarBoleto = scanner.nextDouble();
                        if (pagarBoleto > saldoBancario) {
                            System.out.println("Não há saldo suficiente para pagar o boleto");
                        }
                    } while (pagarBoleto > saldoBancario);
                    saldoBancario -= pagarBoleto;
                    System.out.println("Valor do boleto pago: " + pagarBoleto);
                    System.out.println("Titular da conta: " + nomeTitular);
                    System.out.println("Tipo da conta: " + tipoConta);
                    break;

                default:
                    System.out.println("Saindo....");
                    break;
            }

        }while(opcao < 1 || opcao > 5);
    }
}
