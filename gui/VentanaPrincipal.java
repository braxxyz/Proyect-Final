package gui;
 
import modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JTextField txtNombre, txtCedula, txtCorreo;
    private JComboBox<String> comboClase;
    private JTextArea txtSalida;
    private JButton btnReservar;

     public VentanaPrincipal() {
        setTitle("Sistema de Reservación de Vuelos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

         // Panel principal
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        // entradas
        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panel.add(txtCedula);

        panel.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        panel.add(txtCorreo);

        panel.add(new JLabel("Clase:"));
        comboClase = new JComboBox<>(new String[]{"ejecutiva", "economica"});
        panel.add(comboClase);

        // Botón
        btnReservar = new JButton("Reservar");
        panel.add(btnReservar);

        // Área de salida
        txtSalida = new JTextArea();
        txtSalida.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtSalida);

        // Layout general
        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Acción del botón
        btnReservar.addActionListener(new ActionListener()) {
            
            public void actionPerformed(ActionEvent e) {
                reservar();
            }
         
    }

};
               Reservacion reservacion = new Reservacion(pasajero, vuelo, clase);

            // Mostrar resultado
            txtSalida.setText(reservacion.mostrarReservacion());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error: " + ex.getMessage(),
                "Reservación fallida",
                JOptionPane.ERROR_MESSAGE);
}
    
    
