public class Avion {
    
    private String codigoAvion;
    private int capacidadEjecutiva;
    private int capacidadEconomica;

   
    public Avion(String codigoAvion, int capacidadEjecutiva, int capacidadEconomica) {
        this.codigoAvion = codigoAvion;
        this.capacidadEjecutiva = capacidadEjecutiva;
        this.capacidadEconomica = capacidadEconomica;
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