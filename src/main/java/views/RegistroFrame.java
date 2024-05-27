package views;

import clases.SistemaGestionUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroFrame extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnRegistrar;
    private SistemaGestionUsuarios sistemaGestionUsuarios;

    public RegistroFrame(SistemaGestionUsuarios sistemaGestionUsuarios) {
        this.sistemaGestionUsuarios = sistemaGestionUsuarios;

        setTitle("Inventario de Alimentos - Registro");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con el logo
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(new Color(204, 255, 204));
        JLabel lblLogo = new JLabel("Inventario de Alimentos", JLabel.CENTER);
        lblLogo.setFont(new Font("Arial", Font.BOLD, 24));
        lblLogo.setForeground(new Color(0, 153, 0));
        panelLogo.add(lblLogo);
        add(panelLogo, BorderLayout.NORTH);

        // Panel central con el formulario de registro
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(new Color(204, 255, 204));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelFormulario.add(lblUsuario, constraints);

        txtUsuario = new JTextField(20);
        constraints.gridx = 1;
        panelFormulario.add(txtUsuario, constraints);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
        constraints.gridx = 0;
        constraints.gridy = 1;
        panelFormulario.add(lblPassword, constraints);

        txtPassword = new JPasswordField(20);
        constraints.gridx = 1;
        panelFormulario.add(txtPassword, constraints);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setBackground(new Color(0, 153, 0));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panelFormulario.add(btnRegistrar, constraints);

        add(panelFormulario, BorderLayout.CENTER);

        // Evento del botón de registro
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = txtUsuario.getText();
                String password = new String(txtPassword.getPassword());

                // Verificar si los campos de texto están vacíos
                if (nombreUsuario.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistroFrame.this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                boolean registrado = sistemaGestionUsuarios.registrarUsuario(nombreUsuario, password);
                if (registrado) {
                    JOptionPane.showMessageDialog(RegistroFrame.this, "Usuario registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegistroFrame.this, "El nombre de usuario ya existe. Intente con otro nombre.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}


