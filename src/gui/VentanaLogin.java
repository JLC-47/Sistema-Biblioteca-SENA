package gui;

import javax.swing.*;
import java.awt.*;
import config.Configuracion;
import models.*;
import utils.Validador;

public class VentanaLogin extends JFrame {
    private int intentos = 0;
    Validador validador = new Validador();

    public VentanaLogin(GestionUsuarios gu, GestorLibros gl, GestorPrestamos gp) {
        setTitle("Login - " + Configuracion.NOMBRE_BIBLIOTECA);
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JTextField txtDoc = new JTextField();
        JPasswordField txtPass = new JPasswordField();
        JButton btnEntrar = new JButton("Iniciar Sesión");
        JButton btnReg = new JButton("Registrar Lector");

        btnEntrar.setBackground(new Color(46, 204, 113));
        btnEntrar.setForeground(Color.WHITE);

        panel.add(new JLabel("Documento:"));
        panel.add(txtDoc);
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPass);
        panel.add(new JLabel(""));
        panel.add(btnEntrar);
        panel.add(btnReg);

        add(panel);

        btnEntrar.addActionListener(e -> {
            String d = txtDoc.getText();
            String p = new String(txtPass.getPassword());
            Usuarios u = gu.buscarUsuario(d);

            boolean isAdmin = d.equals(Configuracion.ADMIN_USER) && p.equals(Configuracion.ADMIN_PASS);
            boolean isUser = (u != null && p.equals(u.getDocumento()));

            if (isAdmin || isUser) {
                if (isAdmin && u == null) u = new Usuarios("admin", "Administrador", "Administrador");
                new VentanaPrincipal(u, gl, gu, gp).setVisible(true);
                dispose();
            } else {
                intentos++;
                if (intentos >= Configuracion.MAX_INTENTOS) {
                    JOptionPane.showMessageDialog(this, "BLOQUEO DE SEGURIDAD");
                    System.exit(0);
                }
                JOptionPane.showMessageDialog(this, "Fallo " + intentos + " de " + Configuracion.MAX_INTENTOS);
            }
        });

        btnReg.addActionListener(e -> {
            
            String doc = JOptionPane.showInputDialog("Documento:");
            String nom = JOptionPane.showInputDialog("Nombre:");
            validador.validarCampo(nom);
            validador.validarCampo(doc);
            if (doc != null && nom != null) {
                gu.registrarUsuario(doc, nom, "Lector");
                JOptionPane.showMessageDialog(this, "Registrado con éxito");
            }


        });
    }
}