package modelo;
public class Vuelo {
    // Atributos
    private String codigoVuelo;
    private String origen;
    private String destino;
    private Avion avion;
    private int espaciosEjecutivaDisponibles;
    private int espaciosEconomicaDisponibles;

   
    public Vuelo(String codigoVuelo, String origen, String destino, Avion avion) {
        this.codigoVuelo = codigoVuelo;
        this.origen = origen;
        this.destino = destino;
        this.avion = avion;
        this.espaciosEjecutivaDisponibles = avion.getCapacidadEjecutiva();
        this.espaciosEconomicaDisponibles = avion.getCapacidadEconomica();
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigen() {
        return origen;
    }
  
    public boolean verificarDisponibilidad(String clase) {
        if (clase.equalsIgnoreCase("ejecutiva")) {
            return espaciosEjecutivaDisponibles > 0;
        } else if (clase.equalsIgnoreCase("economica")) {
            return espaciosEconomicaDisponibles > 0;
        } else {
            return false;
        }
    }

    public void reservarEspacio(String clase) {
        if (verificarDisponibilidad(clase)) {
            if (clase.equalsIgnoreCase("ejecutiva")) {
                espaciosEjecutivaDisponibles--;
            } else {
                espaciosEconomicaDisponibles--;
            }
            System.out.println("✅ Asiento reservado en clase " + clase);
        } else {
            System.out.println("❌ No hay espacios disponibles en clase " + clase);
        }
    }

   public void mostrarInfo() {
    System.out.println("Código de vuelo: " + codigoVuelo);
    System.out.println("Origen: " + origen);
    System.out.println("Destino: " + destino);
    System.out.println("Avión asignado: " + avion.getCodigoAvion());
    System.out.println("Disponibilidad Ejecutiva: " + espaciosEjecutivaDisponibles);
    System.out.println("Disponibilidad Económica: " + espaciosEconomicaDisponibles);
}   
}