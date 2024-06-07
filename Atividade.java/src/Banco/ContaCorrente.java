package Banco;

public class ContaCorrente extends Conta{
    double taxaManutencao = 50.0;
    public ContaCorrente(int numeroDaAgencia, int numeroDaConta, double saldo, Cliente cliente) {
        super(numeroDaAgencia, numeroDaConta, saldo, cliente);
        
    }

    public double simularOperacao(int quantidadeDeMeses) {
        double total = 0.0;
        if (quantidadeDeMeses >= 0) { 
            double saldo = this.getSaldo();
          double custo = quantidadeDeMeses * taxaManutencao;
          saldo =  saldo - custo;
          total = saldo;
        }
        return total;
    }   
    
}
