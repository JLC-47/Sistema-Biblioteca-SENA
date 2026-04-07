package models;

import java.util.ArrayList;

import config.Configuracion;

public class GestorPrestamos {
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    public boolean registrarPrestamo(Usuarios usuario, Libros libro) {
        if (!libro.getEstado().equalsIgnoreCase("Disponible")) {
            System.out.println("El libro no está disponible.");
            return false;
        }

        int conteo = 0;
        for (Prestamo p : listaPrestamos) {
            if (p.getCategoria().equals(usuario.getDocumento())) {
                conteo++;
            }
        }

        if (usuario.getTipoUsuario().equalsIgnoreCase("Lector") && conteo >= Configuracion.MAX_PRESTAMOS) {
            System.out.println("Límite de préstamos alcanzado.");
            return false;
        }

        libro.setEstado("Prestado");
        Prestamo nuevo = new Prestamo(2026, usuario.getDocumento(), Configuracion.MAX_PRESTAMOS);
        listaPrestamos.add(nuevo);
        return true;
    }
}
