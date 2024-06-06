package Banco;

public class ContaCorrente extends Conta{
    double taxaManutencao = 50.0;
    public ContaCorrente(String numeroDaAgencia, String numeroDaConta, double saldo, Cliente cliente) {
        super(numeroDaAgencia, numeroDaConta, saldo, cliente);
        
    }

    public void simularOperacao(int quantidadeDeMeses) {
        if (quantidadeDeMeses >= 0) { 
            double saldo = this.getSaldo();
          double custo = quantidadeDeMeses * taxaManutencao;
          saldo =  saldo - custo;
          System.out.println("Em " + quantidadeDeMeses + ", o saldo do cliente será R$" + saldo); 
        }
        else {
            System.out.println("O valor " + quantidadeDeMeses + "é inválido!");
         }
    }
    
}
