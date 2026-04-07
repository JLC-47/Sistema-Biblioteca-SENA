package main;

import gui.VentanaLogin;
import models.*;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        GestorLibros gl = new GestorLibros();
        GestionUsuarios gu = new GestionUsuarios();
        GestorPrestamos gp = new GestorPrestamos();

        gu.registrarUsuario("101", "Janier Administrador", "Administrador");
        gu.registrarUsuario("102", "Lucía Torres", "Bibliotecario");
        gu.registrarUsuario("103", "Andrés Lector", "Lector");
        gu.registrarUsuario("104", "Marcos Ruiz", "Lector");
        gu.registrarUsuario("105", "Elena Gómez", "Lector");

        gl.agregarLibro(1001, "Java a Fondo", "Pablo Sznajdleder", 2021, "Disponible");
        gl.agregarLibro(1002, "Clean Code", "Robert C. Martin", 2008, "Disponible");
        gl.agregarLibro(1003, "Cien Años de Soledad", "Gabo", 1967, "Disponible");
        gl.agregarLibro(2001, "El Psicoanalista", "John Katzenbach", 2002, "Disponible");
        gl.agregarLibro(2002, "Sapiens", "Yuval Noah Harari", 2014, "Disponible");

        SwingUtilities.invokeLater(() -> {
            new VentanaLogin(gu, gl, gp).setVisible(true);
        });
    }
}