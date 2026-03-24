package models;

public class GestorLibros {
    package models;

import java.util.List;
import java.util.Scanner;

public class GestorLibros {
    public static void buscarLibro(List<Libro> libros, Scanner sc) {
    System.out.print("Ingrese el ISBN del libro: ");
    String isbn = sc.nextLine();

    boolean encontrado = false;

    for (Libro libro : libros) {
        if (libro.getIsbn().equals(isbn)) {
            System.out.println("\nLibro encontrado:");
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año: " + libro.getAnio());
            System.out.println("Estado: " + libro.getEstado());
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        System.out.println("Libro no encontrado.");
    }
}
}
 
// eliminar

public static void eliminarLibro(List<Libro> libros, Scanner sc) {
    System.out.print("Ingrese el ISBN del libro a eliminar: ");
    String isbn = sc.nextLine();

    Iterator<Libro> iterator = libros.iterator();
    boolean eliminado = false;

    while (iterator.hasNext()) {
        Libro libro = iterator.next();
        if (libro.getIsbn().equals(isbn)) {
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
}
