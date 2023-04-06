public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Ruan");
        cliente1.setCpf(12345678900L);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Ruanita");
        cliente2.setCpf(98765432100L);

        Conta conta1 = new Conta(cliente1,1000.00);
        Conta conta2 = new Conta(cliente2, 5333.25);

        conta1.saca(1200.75);
        conta1.deposita(350.25);

        conta2.saca(3500.00);

        conta1.extrato();
        conta2.extrato();

        System.out.println("\nNúmero total de clientes do banco: " + Conta.getQntClientes());

    }
}