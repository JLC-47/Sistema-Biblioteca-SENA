package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import models.*;
import utils.Validador;
import config.Configuracion;

public class VentanaPrincipal extends JFrame {
    private JPanel mainArea;
    Validador validador = new Validador();

    public VentanaPrincipal(Usuarios u, GestorLibros gl, GestionUsuarios gu, GestorPrestamos gp) {
        setTitle(Configuracion.NOMBRE_BIBLIOTECA);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel sidebar = new JPanel(new GridLayout(12, 1, 5, 5));
        sidebar.setBackground(new Color(44, 62, 80));
        sidebar.setPreferredSize(new Dimension(220, 600));

        JLabel lblUser = new JLabel(u.getNombreCompleto(), SwingConstants.CENTER);
        lblUser.setForeground(Color.WHITE);
        sidebar.add(lblUser);

        JButton btnLibros = crearBtn("Ver Catálogo");
        sidebar.add(btnLibros);

        JButton btnSolicitar = null;
        JButton btnHistorial = null;
        if (u.getTipoUsuario().equals("Lector")) {
            btnSolicitar = crearBtn("Solicitar Préstamo");
            btnHistorial = crearBtn("Mi Historial");
            sidebar.add(btnSolicitar);
            sidebar.add(btnHistorial);
        }

        JButton btnRegLibro = null;
        JButton btnGestionPrestamos = null;
        if (!u.getTipoUsuario().equals("Lector")) {
            btnRegLibro = crearBtn("Nuevo Libro");
            btnGestionPrestamos = crearBtn("Gestionar Préstamos");
            sidebar.add(btnRegLibro);
            sidebar.add(btnGestionPrestamos);
        }

        JButton btnUsers = null;
        if (u.getTipoUsuario().equals("Administrador")) {
            btnUsers = crearBtn("Ver Usuarios");
            sidebar.add(btnUsers);
        }

        JButton btnSalir = crearBtn("Cerrar Sesión");
        btnSalir.setBackground(new Color(192, 57, 43));
        sidebar.add(btnSalir);

        add(sidebar, BorderLayout.WEST);

        mainArea = new JPanel(new BorderLayout());
        mainArea.setBackground(Color.WHITE);
        add(mainArea, BorderLayout.CENTER);

        btnLibros.addActionListener(e -> mostrarLibros(gl));

        if (btnSolicitar != null) {
            btnSolicitar.addActionListener(e -> {
                String isbn = JOptionPane.showInputDialog("ISBN del libro:");
                validador.validarCampo(isbn);
                if (isbn != null) {
                    Libros l = gl.obtenerLibroPorISBN(Integer.parseInt(isbn));
                    if (l != null && gp.registrarPrestamo(u, l)) {
                        JOptionPane.showMessageDialog(this, "Préstamo exitoso");
                        mostrarLibros(gl);
                    } else {
                        JOptionPane.showMessageDialog(this, "No disponible o límite excedido");
                    }
                }
            });
        }

        if (btnHistorial != null) {
            btnHistorial.addActionListener(e -> {
                String[] col = {"ISBN Libro", "Fecha", "Límite"};
                DefaultTableModel model = new DefaultTableModel(col, 0);
                for (Prestamo p : gp.obtenerHistorialUsuario(u.getDocumento())) {
                    model.addRow(new Object[]{p.getLimitePrestamo(), p.getFechaPrestamo(), "Activo"});
                }
                actualizarTab(new JTable(model));
            });
        }

        if (btnGestionPrestamos != null) {
            btnGestionPrestamos.addActionListener(e -> {
                String[] col = {"Lector (Doc)", "ISBN Libro", "Fecha"};
                DefaultTableModel model = new DefaultTableModel(col, 0);
                for (Prestamo p : gp.getListaPrestamos()) {
                    model.addRow(new Object[]{p.getCategoria(), p.getLimitePrestamo(), p.getFechaPrestamo()});
                }
                actualizarTab(new JTable(model));
            });
        }

        if (btnRegLibro != null) {
            btnRegLibro.addActionListener(e -> {
                try {
                    int i = Integer.parseInt(JOptionPane.showInputDialog("ISBN:"));
                    validador.validarISBN(i);
                    String t = JOptionPane.showInputDialog("Título:");
                    validador.validarCampo(t);
                    String a = JOptionPane.showInputDialog("Autor:");
                    validador.validarCampo(a);
                    int an = Integer.parseInt(JOptionPane.showInputDialog("Año:"));
                    gl.agregarLibro(i, t, a, an, "Disponible");
                    mostrarLibros(gl);



                } catch (Exception ex) {}
            });
        }

        if (btnUsers != null) {
            btnUsers.addActionListener(e -> mostrarUsuarios(gu));
        }

        btnSalir.addActionListener(e -> {
            new VentanaLogin(gu, gl, gp).setVisible(true);
            dispose();
        });
    }

    private void mostrarLibros(GestorLibros gl) {
        String[] col = {"ISBN", "Título", "Autor", "Estado"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        for (Libros l : gl.getLibros()) {
            model.addRow(new Object[]{l.getISBN(), l.getTitulo(), l.getAutor(), l.getEstado()});
        }
        actualizarTab(new JTable(model));
    }

    private void mostrarUsuarios(GestionUsuarios gu) {
        String[] col = {"Documento", "Nombre", "Rol"};
        DefaultTableModel model = new DefaultTableModel(col, 0);
        for (Usuarios u : gu.getUsuarios()) {
            model.addRow(new Object[]{u.getDocumento(), u.getNombreCompleto(), u.getTipoUsuario()});
        }
        actualizarTab(new JTable(model));
    }

    private void actualizarTab(JTable t) {
        mainArea.removeAll();
        mainArea.add(new JScrollPane(t), BorderLayout.CENTER);
        mainArea.revalidate();
        mainArea.repaint();
    }

    private JButton crearBtn(String t) {
        JButton b = new JButton(t);
        b.setFocusPainted(false);
        b.setBackground(new Color(52, 73, 94));
        b.setForeground(Color.WHITE);
        return b;
    }
}