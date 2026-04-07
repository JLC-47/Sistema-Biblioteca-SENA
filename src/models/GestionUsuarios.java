package models;

import java.util.ArrayList;

public class GestionUsuarios {

    private ArrayList<Usuarios> listaUsuarios = new ArrayList<>();

    public boolean registrarUsuario(String documento, String nombre, String tipo) {
        for (Usuarios u : listaUsuarios) {
            if (u.getDocumento().equals(documento)) {
                return false;
            }
        }
        Usuarios nuevo = new Usuarios(documento, nombre, tipo);
        listaUsuarios.add(nuevo);
        return true;
    }

    public boolean eliminarUsuario(String documento) {
        Usuarios usuario = buscarUsuario(documento);
        if (usuario != null) {
            listaUsuarios.remove(usuario);
            return true;
        }
        return false;
    }

    public boolean actualizarUsuario(String documento, String nuevoNombre, String nuevoTipo) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getDocumento().equals(documento)) {
                listaUsuarios.set(i, new Usuarios(documento, nuevoNombre, nuevoTipo));
                return true;
            }
        }
        return false;
    }

    public Usuarios buscarUsuario(String documento) {
        for (Usuarios u : listaUsuarios) {
            if (u.getDocumento().equals(documento)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Usuarios> getUsuarios() {
        return listaUsuarios;
    }
}