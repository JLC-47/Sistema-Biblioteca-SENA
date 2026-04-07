package models;

import java.util.*;

public class GestorLibros {

    private ArrayList<Libros> libros;

    public GestorLibros() {
        libros = new ArrayList<>();
    }

    // Registrar libro
    public void agregarLibro(int isbn, String titulo, String autor, int anio, String state) {

        // Validar campos vacíos
        if (isbn == 0 || titulo.isEmpty() || autor.isEmpty()) {
            System.out.println("Error: Ningún campo puede estar vacío.");
            return;
        }

        // Validar ISBN único
        for (Libros l : libros) {
            if (l.getISBN() == isbn) {
                System.out.println("Error: El ISBN ya existe.");
                return;
            }
        }

        // Validar año
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        if (anio > anioActual) {
            System.out.println("Error: El año no puede ser mayor al actual.");
            return;
        }

        Libros libro = new Libros(isbn,  titulo, autor, anio, state);
        libros.add(libro);

        System.out.println("Libro registrado correctamente.");
    }

    //  Buscar libro por ISBN
    public void buscarLibro(int  isbn) {
        boolean encontrado = false;

        for (Libros libro : libros) {
            if (libro.getISBN() == isbn) {
                System.out.println("\nLibro encontrado:");
                System.out.println("ISBN: " + libro.getISBN());
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Año: " + libro.getAnioPublicacion() );
                System.out.println("Estado: " + libro.getEstado());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Libro no encontrado.");
        }
    }

    //  Eliminar libro
    public void eliminarLibro(int isbn) {
        Iterator<Libros> iterator = libros.iterator();
        boolean eliminado = false;

        while (iterator.hasNext()) {
            Libros libro = iterator.next();
            if (libro.getISBN() == isbn) {
                iterator.remove();
                System.out.println("Libro eliminado correctamente.");
                eliminado = true;
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró un libro con ese ISBN.");
        }
    }

    //  Listar libros
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        System.out.println("\nLista de libros:");
        for (Libros libro : libros) {
            System.out.println("-------------------------");
            System.out.println("ISBN: " + libro.getISBN());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año: " + libro.getAnioPublicacion());
            System.out.println("Estado: " + libro.getEstado());
        }
    }

    //  Actualizar estado (Disponible / Prestado)
    public void actualizarEstado(int isbn, String nuevoEstado) {
        for (Libros libro : libros) {
            if (libro.getISBN() == isbn) {
                libro.setEstado(nuevoEstado);
                System.out.println("Estado actualizado correctamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
}