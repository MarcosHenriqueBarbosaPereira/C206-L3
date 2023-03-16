public class Main {
    public static void main(String[] args) {

        Carro car1 = new Carro();
        Carro car2 = new Carro();

        car1.cor = "Azul";
        car1.marca = "Tesla";
        car1.modelo = "Model X";
        car1.velocidadeMax = 155.0;
        car1.velocidadeAtual = 0; //desligado;
        car1.motor.potencia = 611; //HP;
        car1.motor.tipo = "AWD 60D";

        car2.cor = "Branco";
        car2.marca = "Mercedes";
        car2.modelo = "BENZ A 200";
        car2.velocidadeMax = 142.9;
        car2.velocidadeAtual = 0; //desligado;
        car2.motor.potencia = 163; //HP;
        car2.motor.tipo = "1.3 Turbo";

        car1.ligar();
        car2.ligar();

        car1.acelerar();
        car2.acelerar();

        car1.mostraInfo();
        car2.mostraInfo();
    }
}