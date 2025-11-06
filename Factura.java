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
    sb.append("Pasajero").append(pasajero.getNombre()).append("\n");
    sb

}






}