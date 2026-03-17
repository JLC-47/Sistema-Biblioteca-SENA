import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaUsuarios sistema = new SistemaUsuarios();

        int opcion;

        do {

            System.out.println("\n--- SISTEMA DE USUARIOS ---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");

            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Documento: ");
                    String documento = sc.nextLine();

                    System.out.print("Nombre completo: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tipo (Administrador/Bibliotecario/Lector): ");
                    String tipo = sc.nextLine();

                    if (documento.isEmpty() || nombre.isEmpty() || tipo.isEmpty()) {
                        System.out.println("Error: campos obligatorios");
                        break;
                    }

                    if (!tipo.equalsIgnoreCase("Administrador") &&
                        !tipo.equalsIgnoreCase("Bibliotecario") &&
                        !tipo.equalsIgnoreCase("Lector")) {

                        System.out.println("Tipo de usuario inválido");
                        break;
                    }

                    boolean registrado = sistema.registrarUsuario(documento, nombre, tipo);

                    if (registrado) {
                        System.out.println("Usuario registrado correctamente");
                    } else {
                        System.out.println("El documento ya existe");
                    }

                    break;

                case 2:

                    sistema.listarUsuarios();

                    break;

                case 3:

                    System.out.print("Documento a buscar: ");
                    String docBuscar = sc.nextLine();

                    Usuario u = sistema.buscarUsuario(docBuscar);

                    if (u != null) {
                        System.out.println("Usuario encontrado:");
                        System.out.println(u);
                    } else {
                        System.out.println("Usuario no encontrado");
                    }

                    break;

                case 4:

                    System.out.print("Documento a eliminar: ");
                    String docEliminar = sc.nextLine();

                    boolean eliminado = sistema.eliminarUsuario(docEliminar);

                    if (eliminado) {
                        System.out.println("Usuario eliminado");
                    } else {
                        System.out.println("Usuario no encontrado");
                    }

                    break;

            }

        } while (opcion != 5);

        System.out.println("Sistema finalizado");
    }
}
