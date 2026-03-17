public class Usuario {
      // Guardar la informacion de el usuario
    private String documento;
    private String nombreCompleto;
    private String tipoUsuario;
       // El constructor de la clase Usuario
    public Usuario(String documento, String nombreCompleto, String tipoUsuario) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.tipoUsuario = tipoUsuario;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    @Override
    public String toString() {
        return "Documento: " + documento +
               " | Nombre: " + nombreCompleto +
               " | Tipo: " + tipoUsuario;
    }
}