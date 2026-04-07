package models;

import java.util.*;

public class GestorLibros {

    private ArrayList<Libros> libros;

    public GestorLibros() {
        libros = new ArrayList<>();
    }

    public boolean agregarLibro(int isbn, String titulo, String autor, int anio, String state) {
        if (isbn == 0 || titulo.isEmpty() || autor.isEmpty()) {
            return false;
        }

        for (Libros l : libros) {
            if (l.getISBN() == isbn) {
                return false;
            }
        }

        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        if (anio > anioActual) {
            return false;
        }

        Libros libro = new Libros(isbn, titulo, autor, anio, state);
        libros.add(libro);
        return true;
    }

    public boolean eliminarLibro(int isbn) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getISBN() == isbn) {
                libros.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarLibro(int isbn, String nuevoTitulo, String nuevoAutor, int nuevoAnio) {
        for (Libros libro : libros) {
            if (libro.getISBN() == isbn) {
                libro.setTitulo(nuevoTitulo);
                libro.setAutor(nuevoAutor);
                libro.setAnioPublicacion(nuevoAnio);
                return true;
            }
        }
        return false;
    }

    public void actualizarEstado(int isbn, String nuevoEstado) {
        for (Libros libro : libros) {
            if (libro.getISBN() == isbn) {
                libro.setEstado(nuevoEstado);
                return;
            }
        }
    }

    public ArrayList<Libros> getLibros() {
        return libros;
    }

    public Libros obtenerLibroPorISBN(int isbn) {
        for (Libros l : libros) {
            if (l.getISBN() == isbn)
                return l;
        }
        return null;
    }

     
}