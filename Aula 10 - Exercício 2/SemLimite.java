public class SemLimite extends Exception{

    public SemLimite(double valor, double limite){
        System.out.println("Seu limite de R$" + limite + " é insuficiente para o saque de R$" + valor);
    }
    
}
