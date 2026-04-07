import java.util.*;

public class GestorLibros {

    private ArrayList<Libros> libros;

    public GestorLibros() {
        libros = new ArrayList<>();
    }

    // Registrar libro
    public void agregarLibro(String isbn, String titulo, String autor, int anio) {

        // Validar campos vacíos
        if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty()) {
            System.out.println("Error: Ningún campo puede estar vacío.");
            return;
        }

        // Validar ISBN único
        for (Libros l : libros) {
            if (l.getIsbn().equals(isbn)) {
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

        Libros libro = new Libro(isbn, titulo, autor, anio, "Disponible");
        libros.add(libro);

        System.out.println("Libro registrado correctamente.");
    }

    //  Buscar libro por ISBN
    public void buscarLibro(String isbn) {
        boolean encontrado = false;

        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                System.out.println("\nLibro encontrado:");
                System.out.println("ISBN: " + libro.getIsbn());
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor());
                System.out.println("Año: " + libro.getAnio() );
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
    public void eliminarLibro(String isbn) {
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

    //  Listar libros
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        System.out.println("\nLista de libros:");
        for (Libro libro : libros) {
            System.out.println("-------------------------");
            System.out.println("ISBN: " + libro.getIsbn());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año: " + libro.getAnio());
            System.out.println("Estado: " + libro.getEstado());
        }
    }

    //  Actualizar estado (Disponible / Prestado)
    public void actualizarEstado(String isbn, String nuevoEstado) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.setEstado(nuevoEstado);
                System.out.println("Estado actualizado correctamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }
}