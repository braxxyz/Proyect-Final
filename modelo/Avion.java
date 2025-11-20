package modelo;
public class Avion {
    
    private String codigoAvion;
    private int capacidadEjecutiva = 2;
    private int capacidadEconomica = 2;

   
    public Avion(String codigoAvion) {
    this.codigoAvion = codigoAvion;
    this.capacidadEjecutiva = 2;
    this.capacidadEconomica = 2;
}

    

 
    public String getCodigoAvion() {
        return codigoAvion;
    }

    public int getCapacidadEjecutiva() {
        return capacidadEjecutiva;
    }

    public int getCapacidadEconomica() {
        return capacidadEconomica;
    }

   
    public void mostrarInfo() {
        System.out.println("Código del avión: " + codigoAvion);
        System.out.println("Capacidad Ejecutiva: " + capacidadEjecutiva);
        System.out.println("Capacidad Económica: " + capacidadEconomica);
    }
}