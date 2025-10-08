/*1. Crie uma classe base `Produto` com atributos `nome` e `preco`.
2. Crie as subclasses `ProdutoEletronico`, `ProdutoRoupa` e `ProdutoLivro`, que herdam de
`Produto`.
3. Adicione um método polimórfico `calcularPrecoFinal()` em `Produto`.
4. Na subclasse `ProdutoEletronico`, o preço deve ser o preço base com um desconto de 10%.
5. Na subclasse `ProdutoRoupa`, o preço deve ser o preço base com um desconto de 20%.
6. Na subclasse `ProdutoLivro`, o preço deve ser o preço base sem desconto.*/

import java.util.ArrayList;
import java.util.List;

// Classe base
class Produto {

    protected String nome;
    protected double preco;

    public Produto (String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco (double preco) {
        this.preco = preco;
    }

    // Metodo polimorfico
    public double calcularPrecoFinal() {
        return preco;
    }

    public void exibirInfo() {
        System.out.println(nome + "- Preço final: R$" +calcularPrecoFinal());
    }
}

class ProdutoEletronico extends Produto {

    public ProdutoEletronico(String nome, double preco) {
        super (nome, preco);
    }

    @Override
    public double calcularPrecoFinal() {
        return preco * 0.9;
    }

}

class ProdutoRoupa extends Produto {

    public ProdutoRoupa(String nome, double preco) {
        super (nome, preco);
    }

    @Override
    public double calcularPrecoFinal() {
        return preco * 0.8;
    }

}

class ProdutoLivro extends Produto {

    public ProdutoLivro(String nome, double preco) {
        super (nome, preco);
    }

    @Override
    public double calcularPrecoFinal() {
        return preco;
    }

}

public class lojaProdutos {
    public static void main(String[] args) {

        Produto p1 = new ProdutoEletronico("Notebook", 5000.0);
        Produto p2 = new ProdutoRoupa("Camiseta", 100.0);
        Produto p3 = new ProdutoLivro("Livro de Java", 80.0);

        // Lista polimorfica

        List <Produto> produtos = new ArrayList<>();
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);

        for (Produto produto : produtos) {
            produto.exibirInfo();
        }

    }
}