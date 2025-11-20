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
    sb.append("=== Reservación ===\n");
    sb.append("Pasajero: ").append(pasajero.getNombre()).append("\n");
    sb.append("Vuelo: ").append(vuelo.getOrigen()).append(" -> ").append(vuelo.getDestino()).append("\n");
    sb.append("Clase: ").append(clase).append("\n");
    sb.append("Código de tiquete: ").append(tiquete.getCodigoTiquete()).append("\n\n");
    sb.append(factura.GenerarTextoFactura());
    return sb.toString();
}
}
