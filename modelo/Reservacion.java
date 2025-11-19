package modelo;

public class Reservacion {
    private Pasajero pasajero;
    private Vuelo vuelo;
    private String clase;
    private Tiquete tiquete;
    private Factura factura;

     public Reservacion(Pasajero pasajero, Vuelo vuelo, String clase) {
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.clase = clase;
         // Crear el tiquete 
        this.tiquete = new Tiquete(pasajero, vuelo, clase);

        // Generar una factura a partir del tiquete
        this.factura = tiquete.generarFactura();
    }
     
    public Tiquete getTiquete() {
        return tiquete;
    }
    public Factura getFactura() {
        return factura;
    }
    
     public String mostrarReservacion() {
        StringBuilder sb = new StringBuilder();
        sb.append(tiquete.getCodigoTiquete()).append("\n");
        sb.append(tiquete.generarFactura().GenerarTextoFactura()).append("\n");
        return sb.toString();
    }  
}
