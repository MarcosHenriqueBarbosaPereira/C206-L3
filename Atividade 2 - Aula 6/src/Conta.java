public class Conta {

    private static int qntClientes=0;
    private double saldo;
    Cliente cliente;

    public Conta(Cliente cliente, double saldo){
        qntClientes++;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public void deposita(double valor){
        setSaldo(this.saldo+valor);
    }

    public void saca(double valor){
        if(valor<=saldo)
            setSaldo(saldo-valor);
        else System.out.println("Saldo insuficiente para o saque de " + valor + "R$.");
    }

    public void extrato(){
        System.out.println("O cliente " + cliente.getNome() + " de CPF " + cliente.getCpf() + " possui um saldo de: " + getSaldo() + "R$");
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public static int getQntClientes() {
        return qntClientes;
    }
}
