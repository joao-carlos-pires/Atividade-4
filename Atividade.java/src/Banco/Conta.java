package Banco;
import java.util.Scanner;
public class Conta {
    private int numeroDaAgencia;
    private int numeroDaConta;
    private double saldo;
    private Cliente cliente;

    public Conta(int numeroDaAgencia,int numeroDaConta, double saldo, Cliente cliente) {
        this.numeroDaAgencia = numeroDaAgencia;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    public int getNumeroDaAgencia() {
        return numeroDaAgencia;
    }
    public void setNumeroDaAgencia(int numeroDaAgencia) {
        this.numeroDaAgencia = numeroDaAgencia;
    }
    public int getNumeroDaConta() {
        return numeroDaConta;
    }
    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }
    public double getSaldo() {  //alterado private
        return saldo;
    }
    private void setSaldo(double saldo) {  //alterado private
        this.saldo = saldo;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public double deposito(double valor) {
        this.setSaldo(this.getSaldo() + valor);
        return this.getSaldo();
    }
    public double saque(double valor) {
        this.setSaldo(this.getSaldo() - valor);
        return this.getSaldo();
    }
    public void transferencia(Conta conta) {
       Scanner input = new Scanner(System.in);
       double valorTransferencia = 0.0;
       System.out.println("Digite o valor a ser trasnferido:");
       valorTransferencia = input.nextDouble();
       if((this.getSaldo() - valorTransferencia) >= 0) {
       this.setSaldo(this.getSaldo() - valorTransferencia);
       conta.setSaldo(conta.getSaldo() + valorTransferencia);
       }
       else {
        System.out.println("Esse valor está acima do seu limite, o valor que você pode transferir é  R$" + this.getSaldo());
       }
    }

    public void exibirSaldo() {
        System.out.println("O cliente: " + cliente.getNome() + " possui R$" + this.getSaldo());
    }
}
