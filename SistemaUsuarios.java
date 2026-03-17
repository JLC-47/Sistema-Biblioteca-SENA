import java.util.ArrayList;

public class SistemaUsuarios {

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    // Registrar usuario
    public boolean registrarUsuario(String documento, String nombre, String tipo) {

        // validar documento unico
        for (Usuario u : listaUsuarios) {
            if (u.getDocumento().equals(documento)) {
                return false;
            }
        }

        Usuario nuevo = new Usuario(documento, nombre, tipo);
        listaUsuarios.add(nuevo);
        return true;
    }

    // Listar usuarios
    public void listarUsuarios() {

        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        }

        for (Usuario u : listaUsuarios) {
            System.out.println(u);
        }
    }

    // Buscar usuario
    public Usuario buscarUsuario(String documento) {

        for (Usuario u : listaUsuarios) {
            if (u.getDocumento().equals(documento)) {
                return u;
            }
        }

        return null;
    }

    // Eliminar usuario
    public boolean eliminarUsuario(String documento) {

        Usuario usuario = buscarUsuario(documento);

        if (usuario != null) {
            listaUsuarios.remove(usuario);
            return true;
        }

        return false;
    }
}
