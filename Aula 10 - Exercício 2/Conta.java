public class Conta {
    
    private int numero;
    private String nome;
    private double saldo;
    private double limite;

    public Conta(int numero, String nome, double saldo, double limite){
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
        this.limite = limite;
    }

    public void sacar(double valor) throws SemLimite, SemSaldo{
        if(valor > saldo)
            throw new SemSaldo(valor);
        else if(valor > limite)
            throw new SemLimite(valor, limite);
        else{
            System.out.println("Saque executado no valor de R$" + valor + "\n");
            saldo -= valor;
        }
    }

    public void depositar(double valor){
        System.out.println("Deposito executado no valor de R$" + valor + "\n");
        saldo += valor;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite){
        this.limite = limite;
    }
}