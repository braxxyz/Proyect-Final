package gui;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VentanaPrincipal extends JFrame {
    private JTextField txtNombre, txtCedula, txtCorreo, txtClase, txtOrigen, txtDestino;
    private JTextArea areaResultado;
    private JTabbedPane pestañas;

    public VentanaPrincipal() {
        setTitle("✈️ Sistema de Reservación de Vuelos");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pestañas = new JTabbedPane();

        // Panel de formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        panelFormulario.add(crearCampo("Nombre:", txtNombre = new JTextField()));
        panelFormulario.add(crearCampo("Cédula:", txtCedula = new JTextField()));
        panelFormulario.add(crearCampo("Correo:", txtCorreo = new JTextField()));
        panelFormulario.add(crearCampo("Origen:", txtOrigen = new JTextField()));
        panelFormulario.add(crearCampo("Destino:", txtDestino = new JTextField()));
        panelFormulario.add(crearCampo("Clase (ejecutiva/economica):", txtClase = new JTextField()));

        JButton btnReservar = new JButton("🛫 Reservar");
        btnReservar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnReservar.setBackground(new Color(0, 120, 215));
        btnReservar.setForeground(Color.WHITE);
        btnReservar.setFocusPainted(false);
        btnReservar.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnReservar.addActionListener(e -> reservar());

        panelFormulario.add(Box.createVerticalStrut(10));
        panelFormulario.add(btnReservar);

        // Panel de tiquete
        JPanel panelTiquete = new JPanel(new BorderLayout());
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaResultado.setMargin(new Insets(10, 10, 10, 10));
        panelTiquete.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Agregar pestañas
        pestañas.addTab("Formulario", panelFormulario);
        pestañas.addTab("Tiquete", panelTiquete);

        add(pestañas);
    }

    private JPanel crearCampo(String etiqueta, JTextField campo) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JLabel label = new JLabel(etiqueta);
        label.setPreferredSize(new Dimension(180, 25));
        panel.add(label, BorderLayout.WEST);
        panel.add(campo, BorderLayout.CENTER);
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        return panel;
    }

    private void reservar() {
        String nombre = txtNombre.getText().trim();
        String cedula = txtCedula.getText().trim();
        String correo = txtCorreo.getText().trim();
        String origen = txtOrigen.getText().trim();
        String destino = txtDestino.getText().trim();
        String clase = txtClase.getText().trim().toLowerCase();

        Pasajero pasajero = new Pasajero(nombre, cedula, correo);
        Avion avion = new Avion("AV001");
        Vuelo vuelo = new Vuelo("VU001", origen, destino, avion);

        try {
            Reservacion reservacion = new Reservacion(pasajero, vuelo, clase);
            String texto = reservacion.mostrarReservacion();
            areaResultado.setText(texto);
            pestañas.setSelectedIndex(1); // Cambiar a pestaña de tiquete
            guardarEnArchivo(texto);      // Guardar en archivo
        } catch (Exception ex) {
            areaResultado.setText("❌ Error: " + ex.getMessage());
            pestañas.setSelectedIndex(1);
        }
    }

    private void guardarEnArchivo(String contenido) {
        try {
            String nombreArchivo = "tiquete_" + System.currentTimeMillis() + ".txt";
            Files.write(Paths.get(nombreArchivo), contenido.getBytes());
            System.out.println("✅ Tiquete guardado en: " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("❌ Error al guardar el archivo: " + e.getMessage());
        }
    }
}

