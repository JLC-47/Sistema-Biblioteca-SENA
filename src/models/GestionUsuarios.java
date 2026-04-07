package models;

import java.util.ArrayList;

public class GestionUsuarios {

    private ArrayList<Usuarios> listaUsuarios = new ArrayList<>();

    // Registrar usuario
    public boolean registrarUsuario(String documento, String nombre, String tipo) {

        // validar documento unico
        for (Usuarios u : listaUsuarios) {
            if (u.getDocumento().equals(documento)) {
                return false;
            }
        }

        Usuarios nuevo = new Usuarios(documento, nombre, tipo);
        listaUsuarios.add(nuevo);
        return true;
    }

    // Listar usuarios
    public void listarUsuarios() {

        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        }

        for (Usuarios u : listaUsuarios) {
            System.out.println(u);
        }
    }

    // Buscar usuario
    public Usuarios buscarUsuario(String documento) {

        for (Usuarios u : listaUsuarios) {
            if (u.getDocumento().equals(documento)) {
                return u;
            }
        }

        return null;
    }

    // Eliminar usuario
    public boolean eliminarUsuario(String documento) {

        Usuarios usuario = buscarUsuario(documento);

        if (usuario != null) {
            listaUsuarios.remove(usuario);
            return true;
        }

        return false;
    }
}
