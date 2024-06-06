package Banco;

public class ContaPoupanca extends Conta{
    double taxaDeRendimento = 0.05;
    public ContaPoupanca(String numeroDaAgencia, String numeroDaConta, double saldo, Cliente cliente) {
        super(numeroDaAgencia, numeroDaConta, saldo, cliente);
        
    }

    public void simularOperacao(int quantidadeDeMeses) {
        if (quantidadeDeMeses >= 0) {
        double saldo = this.getSaldo();
        for(int i = 0; i < quantidadeDeMeses; i++) {
            saldo = saldo + (saldo * taxaDeRendimento);
        }
       System.out.println("Em " + quantidadeDeMeses + ", o saldo do cliente será R$" + saldo); 
     } else {
        System.out.println("O valor " + quantidadeDeMeses + "é inválido!");
     }
    }   
    
}
