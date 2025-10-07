// Classe base
class Funcionario {

    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " +nome);
        System.out.println("Salário: " +salario);
    }

}

// Subclasse gerente

class Gerente extends Funcionario{

    private String departamento;

    public Gerente(String nome, double salario, String departamento) {
        super(nome, salario);
        this.departamento = departamento;
    }

    public String getdepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override 
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Departamento: " +departamento);
    }

}

// Subclasse programador

class Programador extends Funcionario{

    private String linguagem;

    public Programador(String nome, double salario, String linguagem) {
        super(nome, salario);
        this.linguagem = linguagem;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Linguagem: " +linguagem);
    }

}

public class funcionariosEmpresa {
    public static void main(String[] args) {

        // Objetos das subclasses
        Funcionario f1 = new Gerente("Carlos Silva", 5000.0, "TI");
        Funcionario f2 = new Programador("Ana Souza", 4000.0, "Java");

        System.out.println ("Informações do gerente:");
        f1.exibirInformacoes();
        System.out.println();

        System.out.println ("Informações do programador:");
        f2.exibirInformacoes();

    }
}