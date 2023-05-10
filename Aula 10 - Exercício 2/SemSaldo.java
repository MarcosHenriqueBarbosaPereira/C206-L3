public class SemSaldo extends Exception{

    public SemSaldo(double valor){
        System.out.println("Saldo insuficiente para o saldo de R$" + valor);
    }
    
}
