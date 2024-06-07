package Banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TesteOperacoes {
    private List<Cliente> listaClientes = new ArrayList<>(); ;
    private List<Conta> listaContas = new ArrayList<>();;

    public void criarConta() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do cliente:");
        String nome = input.nextLine();
        input.nextLine();
        System.out.println("Digite o endereço");
        String endereco = input.nextLine();
        input.nextLine();
        System.out.println("Digite a profissão do cliente: ");
        String profissao = input.next();
        Cliente cliente = new Cliente(nome, endereco, profissao);
        input.close();
    }


    public void realizarOperacacoes(int numeroDaAgenciaOrigem, int numeroDaContaOrigem, int numeroDaAgenciaDestino, int numeroDaContaDestino ) {
        Conta contaOrigem = null, contaDestino = null;
        boolean origem = false, destino = false;
        for(int i = 0; i < listaContas.size(); i++) {
            if((listaContas.get(i).getNumeroDaAgencia() == numeroDaAgenciaOrigem) && (listaContas.get(i).getNumeroDaConta() == numeroDaContaOrigem)) {
                contaOrigem = listaContas.get(i);
                origem = true;
            }
            if((listaContas.get(i).getNumeroDaAgencia() == numeroDaAgenciaDestino) && (listaContas.get(i).getNumeroDaConta() == numeroDaContaDestino)) {
                contaDestino = listaContas.get(i);
                destino = true;
            }
        
        }   
        if (origem && destino) {
            contaOrigem.transferencia(contaDestino);
        }
    }

    public void exibirSaldo() {}
        Scanner input = new Scanner(System.in);
        
        Conta contaExibida = null;

}
