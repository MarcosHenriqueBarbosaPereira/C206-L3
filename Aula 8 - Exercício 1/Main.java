public class Main {
    
    public static void main(String[] args) {
        
        Sedan sedan = new Sedan(50000, "Preto", 2010, 2);
        SUV suv = new SUV(75000,"Azul",2015,"4 rodas");
        Hatch hatch = new Hatch(100000, "Rosa", 2020, 4);

        sedan.mostrarInfo();
        sedan.taxa();

        suv.mostrarInfo();
        suv.taxa();

        hatch.mostrarInfo();
        hatch.taxa();

    }
}
