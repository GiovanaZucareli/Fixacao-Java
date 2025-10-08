import java.util.ArrayList;
import java.util.List;

// Classe base
class ContaBancaria {

    public String titular;
    public double saldo;

    // Construtor

    public ContaBancaria (String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular (String titular) {
        this.titular = titular;
    }

    public void setSaldo (double saldo) {
        this.saldo = saldo;
    }

    // Método depositar
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Foi depositado R$" +valor);
    }

    // Método sacar
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Foi sacado R$" +valor);
        }else {
            System.out.println("Saldo insuficiente. Tentou sacar R$" +valor);
        }
    }

    // Exibir saldo
    public void exibirSaldo() {
        System.out.println("Titular: " + titular + " | Saldo atual: R$" + saldo);
    }

}

// Subclasse conta corrente
class ContaCorrente extends ContaBancaria {
    private double taxaSaque;

    public ContaCorrente (String titular, double saldoInicial, double taxaSaque) {
        super(titular, saldoInicial);
        this.taxaSaque = taxaSaque;
    }

    @Override
    public void sacar(double valor) {
        double valorTotal = valor + taxaSaque;

        if (valorTotal <= saldo) {
            saldo -= valorTotal;
            System.out.println("Foi sacado R$" +valor);
        }else {
            System.out.println("Saldo insuficiente. Tentou sacar R$" +valor);
        }
    } 
}

class ContaPoupanca extends ContaBancaria {
    private double taxaJuros;

    public ContaPoupanca (String titular, double saldoInicial, double taxaJuros) {
        super(titular, saldoInicial);
        this.taxaJuros = taxaJuros;
    }

    public void render() {
        double rendimento = saldo * taxaJuros;
        saldo += rendimento;
        System.out.println("Rendimento de R$" +rendimento);
    }
}

public class sistemaPagamento {
    public static void main(String[] args) {

        ContaBancaria c1 = new ContaCorrente("Carlos", 1000.0, 5.0);
        ContaBancaria c2 = new ContaPoupanca("Giovana", 2000.0, 0.05);

        // Lista polimorfica
        List<ContaBancaria> contas = new ArrayList<>();

        contas.add(c1);
        contas.add(c2);

        for (ContaBancaria conta : contas) {
            conta.sacar(100);
            conta.exibirSaldo();
        }

        if (c2 instanceof ContaPoupanca) {
            ((ContaPoupanca) c2).render();
            c2.exibirSaldo();
        }
    }
}