public class Factura {

private  Pasajero pasajero;
private  Vuelo vuelo;
private  String  clase;
private double monto;

public Factura (Pasajero pasajero, Vuelo vuelo, String clase, double monto) {
    this.pasajero = pasajero;
    this.vuelo = vuelo;
    this.clase = clase;
    this.monto = monto; 
}

public String GenerarTextoFactura(){
    StringBuilder sb = new StringBuilder();
    sb.append("Pasajero: ").append(pasajero.getNombre()).append("\n");
    sb.append("Cedula: ").append(pasajero.getCedula()).append("\n");
    sb.append("Correo: ").append(pasajero.getCorreo()).append("\n");
    sb.append("Vuelo: ").append(vuelo.getOrigen()).append(" -> ").append(vuelo.getDestino()).append("\n");
    sb.append("Clase: ").append(clase).append("\n");
    sb.append("Monto: $").append(String.format("%.2f", monto));

    return sb.toString();
}

public double getMonto() {
    return monto;
}
public Vuelo getVuelo() {
    return vuelo;
}
public Pasajero getPasajero() {
    return pasajero;
}
public String getClase() {
    return clase;
}

}