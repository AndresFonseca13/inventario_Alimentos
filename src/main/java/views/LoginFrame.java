package views;

import clases.SistemaGestionAlimentos;
import clases.SistemaGestionUsuarios;
import clases.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginFrame extends JFrame {
    private final JTextField txtUser;
    private final JPasswordField txtPassword;

    public LoginFrame(SistemaGestionUsuarios sistemaGestionUsuarios, SistemaGestionAlimentos sistemaGestionAlimentos) {

        setTitle("Inventario de Alimentos - Login");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con el logo
        JPanel panelLogo = new JPanel();
        panelLogo.setLayout(new BoxLayout(panelLogo, BoxLayout.Y_AXIS)); // Ajusta el layout a BoxLayout
        panelLogo.setBackground(new Color(204, 255, 204));

        JLabel lblLogo = new JLabel("Inventario de Alimentos", JLabel.CENTER);
        lblLogo.setFont(new Font("Arial", Font.BOLD, 24));
        lblLogo.setForeground(new Color(0, 153, 0));
        lblLogo.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el JLabel
        panelLogo.add(Box.createVerticalGlue()); // Agrega espacio flexible antes
        panelLogo.add(lblLogo);

        // Cargar la imagen del logo
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/LogoLogin.png"))); // Asegúrate de ajustar la ruta de la imagen según corresponda

        // Crear un JLabel con la imagen del logo
        JLabel lblLogoImagen = new JLabel(imageIcon, JLabel.CENTER);
        lblLogoImagen.setAlignmentX(Component.CENTER_ALIGNMENT); // Centra el JLabel

        // Agregar el JLabel del logo al panel
        panelLogo.add(lblLogoImagen);
        panelLogo.add(Box.createVerticalGlue()); // Agrega espacio flexible después

        add(panelLogo, BorderLayout.NORTH);

        // Panel central con el formulario de login
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(new Color(204, 255, 204));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelFormulario.add(lblUsuario, constraints);

        txtUser = new JTextField(20);
        txtUser.setFont(new Font("Arial", Font.PLAIN, 18));
        constraints.gridx = 1;
        panelFormulario.add(txtUser, constraints);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panelFormulario.add(lblPassword, constraints);

        txtPassword = new JPasswordField(20);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 18));
        constraints.gridx = 1;
        panelFormulario.add(txtPassword, constraints);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 18));
        btnIngresar.setBackground(new Color(0, 153, 0));
        btnIngresar.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btnIngresar, constraints);

        JButton btnRegistro = new JButton("Registro");
        btnRegistro.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegistro.setBackground(new Color(0, 153, 0));
        btnRegistro.setForeground(Color.WHITE);
        constraints.gridy = 3;
        panelFormulario.add(btnRegistro, constraints);

        add(panelFormulario, BorderLayout.CENTER);

        // Evento del botón de ingresar
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = txtUser.getText();
                String password = new String(txtPassword.getPassword());
                User user = sistemaGestionUsuarios.iniciarSesion(userName, password);
                if (user != null) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Inicio de sesión exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new GestionAlimentosFrame(sistemaGestionUsuarios, user, sistemaGestionAlimentos).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Nombre de usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Evento del botón de registro
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroFrame(sistemaGestionUsuarios).setVisible(true);
            }
        });
    }
}

