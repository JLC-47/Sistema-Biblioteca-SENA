package models;

import java.util.ArrayList;
import config.Configuracion;

public class GestorPrestamos {
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    public boolean registrarPrestamo(Usuarios usuario, Libros libro) {
        if (!libro.getEstado().equalsIgnoreCase("Disponible")) {
            return false;
        }

        int conteo = 0;
        for (Prestamo p : listaPrestamos) {
            if (p.getCategoria().equals(usuario.getDocumento())) {
                conteo++;
            }
        }

        if (usuario.getTipoUsuario().equalsIgnoreCase("Lector") && conteo >= Configuracion.MAX_PRESTAMOS) {
            return false;
        }

        libro.setEstado("Prestado");
        Prestamo nuevo = new Prestamo(2026, usuario.getDocumento(), libro.getISBN());
        listaPrestamos.add(nuevo);
        return true;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public ArrayList<Prestamo> obtenerHistorialUsuario(String documento) {
        ArrayList<Prestamo> historial = new ArrayList<>();
        for (Prestamo p : listaPrestamos) {
            if (p.getCategoria().equals(documento)) {
                historial.add(p);
            }
        }
        return historial;
    }
}