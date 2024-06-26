package Banco;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class TesteOperacoes {
    private List<Cliente> listaClientes = new ArrayList<>(); ;
    private List<Conta> listaContas = new ArrayList<>();;

    public void criarConta() {
        Scanner input = new Scanner(System.in);
        try {
        System.out.println("Digite o nome do cliente:");
        String nome = input.nextLine();
        
        System.out.println("Digite o endereço");
        String endereco = input.nextLine();
        
        System.out.println("Digite a profissão do cliente: ");
        String profissao = input.nextLine();
        Cliente cliente = new Cliente(nome, endereco, profissao);
        listaClientes.add(cliente);
        System.out.println("Digite se a conta é poupanca ou corrente");
        String tipoConta = input.nextLine();
        System.out.println("Digite o número da agência:");
        int numeroAgencia = input.nextInt();
         System.out.println("Digite o número da conta:");
        int numeroConta = input.nextInt();
        

        System.out.println("Digite o saldo inicial:");
        double saldo = input.nextDouble();
        if (saldo < 0) throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
         Conta conta = null;
        if ((tipoConta.toLowerCase()).equals("poupanca")) {
            conta = new ContaPoupanca(numeroAgencia, numeroConta, saldo, cliente);
        } else if(tipoConta.toLowerCase().equals("corrente")) {
            conta = new ContaCorrente(numeroAgencia, numeroConta, saldo, cliente);
        }
        listaContas.add(conta);
        
    } catch (InputMismatchException e) {
        System.out.println("Erro: número de agência, conta ou saldo inválido.");
    }
    catch (NumberFormatException e) {
        System.out.println("Erro: número de agência, conta ou saldo inválido.");
    } catch (IllegalArgumentException e) {
        System.out.println("Erro: " + e.getMessage());
    }
             
       
    }


    public void realizarOperacoes(int numeroDaAgenciaOrigem, int numeroDaContaOrigem, int numeroDaAgenciaDestino, int numeroDaContaDestino ) {
        Conta contaOrigem = null, contaDestino = null;
        boolean origem = false, destino = false;
        for(int i = 0; i < listaContas.size(); i++) {
            if((listaContas.get(i).getNumeroDaAgencia() == numeroDaAgenciaOrigem) && (listaContas.get(i).getNumeroDaConta() == numeroDaContaOrigem)) {
                contaOrigem = listaContas.get(i);
                origem = true;
            }
             else if((listaContas.get(i).getNumeroDaAgencia() == numeroDaAgenciaDestino) && (listaContas.get(i).getNumeroDaConta() == numeroDaContaDestino)) {
                contaDestino = listaContas.get(i);
                destino = true;
            }
            else {
                System.out.println("Conta de origem ou de destino não encontrada!");
            }
        
        }   
        if (origem && destino) {
            contaOrigem.transferencia(contaDestino);
        }
    }

    public void exibirSaldo() {
        Conta contaExibida = null;
        int numeroDaAgencia, numeroDaConta, quantidadeDeMeses = 0;
        double simularSaldo = 0.0;
        boolean contaEncontrada = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o número da agência do cliente:");
        numeroDaAgencia = input.nextInt();
        System.out.println("Digite o numero da conta do cliente: ");
        numeroDaConta = input.nextInt();
        
        for(int i = 0; i < listaContas.size(); i++) {
            if ((listaContas.get(i).getNumeroDaAgencia() == numeroDaAgencia) && (listaContas.get(i).getNumeroDaConta() == numeroDaConta))   {
                contaExibida = listaContas.get(i);
                System.out.println("Digite a quantidade de meses para simular: ");
                quantidadeDeMeses = input.nextInt();
                contaEncontrada = true;
                if(contaExibida instanceof ContaCorrente) {
                    simularSaldo = ((ContaCorrente) contaExibida).simularOperacao(quantidadeDeMeses);
                    System.out.println("O saldo após " + quantidadeDeMeses + " é R$" + simularSaldo);
                } else if (contaExibida instanceof ContaPoupanca) {
                    simularSaldo = ((ContaPoupanca) contaExibida).simularOperacao(quantidadeDeMeses);
                    System.out.println("O saldo após " + quantidadeDeMeses + " é R$" + simularSaldo);
                }
                
                
                break; 
            }   
        }   if (!contaEncontrada) {
            System.out.println("Conta não encontrada.");
        }
        
        
        
    }
    public void apresentarMenu() {
        Scanner input = new Scanner(System.in);
        int opcao = -1;
        int numAgenciaOrigem,numAgenciaDestino,numContaOrigem, numContaDestino;
        boolean checagem = true;
        while(checagem) {
            System.out.println("Escolha uma opção a seguir: ");
            System.out.println("1. Criar conta");
            System.out.println("2. Realizar operações");
            System.out.println("3. Exibir saldo");
            System.out.println("4. Sair");
            try{
            opcao = input.nextInt();
            }   
             catch (InputMismatchException ee ) {
                System.out.println("Valor digitado está incorreto");
                break;
             }
              if(opcao == 1) {
                criarConta();
              }
            
            else if( opcao == 2) {
                System.out.println("Digite o numero da agencia");
                try {
                System.out.println("Digite o numero da agência que enviará o valor:");
                numAgenciaOrigem = input.nextInt();
                System.out.println("Digite o numero da conta que enviará o valor:");
                numContaOrigem = input.nextInt();
                System.out.println("Digite o numero da agência que receberá o valor:");
                numAgenciaDestino = input.nextInt();
                System.out.println("Digite o número da conta que receberá o valor");
                numContaDestino = input.nextInt();
                realizarOperacoes(numAgenciaOrigem, numContaOrigem, numAgenciaDestino, numContaDestino);
                }
                catch (InputMismatchException e) {
                    System.out.println("Número de agência inválido");
                    input.nextLine();
                }
                catch (NumberFormatException e1) {
                    System.out.println("Número de agência inválido");
                }
            }
                   
            else if(opcao == 3) {
                    exibirSaldo();
                  
            }
            else if(opcao == 4) {
                    checagem = false;
            }
               else{
                    System.out.println("Opção inválida.");
                    
            }
        } 
    }
}
