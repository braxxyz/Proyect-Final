package modelo;

public class Tiquete {

    private static int contador = 1;

    private String codigoTiquete;
    private Pasajero pasajero;
    private Vuelo vuelo;
    private String clase;
    private double precio;

    public Tiquete(Pasajero pasajero, Vuelo vuelo, String clase) {
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.clase = clase.toLowerCase();
        this.codigoTiquete = "TIC" + contador++;

        if (!vuelo.verificarDisponibilidad(clase)) {
            throw new IllegalArgumentException("No hay espacios disponibles en clase " + clase);
        }

    
        vuelo.reservarEspacio(clase);

        
        calcularPrecio();
    }

    private void calcularPrecio() {
        if (clase.equals("ejecutiva")) {
            precio = 250.00;
        } else if (clase.equals("economica")) {
            precio = 150.00;
        } else {
            precio = 0;
        }
    }

    public Factura generarFactura() {
        return new Factura(
            pasajero,
            vuelo,
            clase,
            precio,
            vuelo.getOrigen(),
            vuelo.getDestino()
        );
    }

    public String getCodigoTiquete() {
        return codigoTiquete;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public String getClase() {
        return clase;
    }

    public double getPrecio() {
        return precio;
    }

    public void mostrarInfo() {
        System.out.println("=== TIQUETE ===");
        System.out.println("Código: " + codigoTiquete);
        System.out.println("Pasajero: " + pasajero.getNombre());
        System.out.println("Vuelo: " + vuelo.getOrigen() + " -> " + vuelo.getDestino());
        System.out.println("Clase: " + clase);
        System.out.println("Precio: $" + precio);
    }
}
