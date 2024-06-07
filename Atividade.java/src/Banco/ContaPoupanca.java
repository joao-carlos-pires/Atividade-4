package Banco;

public class ContaPoupanca extends Conta{
    double taxaDeRendimento = 0.05;
    public ContaPoupanca(int numeroDaAgencia, int numeroDaConta, double saldo, Cliente cliente) {
        super(numeroDaAgencia, numeroDaConta, saldo, cliente);
        
    }

    public double simularOperacao(int quantidadeDeMeses) {
        double total = 0.0;
        if (quantidadeDeMeses >= 0) {
        double saldo = this.getSaldo();
        for(int i = 0; i < quantidadeDeMeses; i++) {
            saldo = saldo + (saldo * taxaDeRendimento);
        }
        total = saldo;
     } 
     return total;
    }   
    
}
