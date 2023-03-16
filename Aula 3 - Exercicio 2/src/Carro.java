public class Carro {

    String cor;
    String marca;
    String modelo;
    double velocidadeMax;
    double velocidadeAtual;

    Motor motor;

    public Carro(){
        motor = new Motor();
    }

    void ligar(){
        velocidadeAtual += velocidadeMax*0.3;
        System.out.println("O carro " + cor + " de marca " + marca + " foi ligado e está com velocidade de " + velocidadeAtual + " mph");
    }
    void acelerar(){
        if((velocidadeAtual+velocidadeMax*0.1) <= velocidadeMax) {
            velocidadeAtual += velocidadeMax * 0.1;
            System.out.println("O carro " + cor + " de marca " + marca + " acelerou para " + velocidadeAtual + " mph");
        }
        else{
            velocidadeAtual = velocidadeMax;
            System.out.println("O carro " + cor + " de marca " + marca + " acelerou para " + velocidadeAtual + " mph");
        }
    }

    void mostraInfo(){
        System.out.println("A seguir serão mostrados dados sobre o carro " + cor + " da " + marca + ":");
        System.out.println("Modelo: "+modelo);
        System.out.println("Tipo do motor: " +motor.tipo);
        System.out.println("Potência do motor: " +motor.potencia);
        System.out.println("Velocidade máxima do veículo: " +velocidadeMax);
        System.out.println("Velociade atual do veículo: " +velocidadeAtual);
    }


}
