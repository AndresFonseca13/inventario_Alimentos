package views;

import clases.SistemaGestionAlimentos;
import clases.SistemaGestionUsuarios;
import clases.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionAlimentosFrame extends JFrame {
    private SistemaGestionUsuarios sistemaGestionUsuarios;
    private User user;
    private SistemaGestionAlimentos sistemaGestionAlimentos;


    public GestionAlimentosFrame(SistemaGestionUsuarios sistemaGestionUsuarios, User user, SistemaGestionAlimentos sistemaGestionAlimentos) {
        this.sistemaGestionUsuarios = sistemaGestionUsuarios;
        this.sistemaGestionAlimentos = sistemaGestionAlimentos;
        this.user = user;

        setTitle("Frutas y Verduras - Gestión de Alimentos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con el título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(204, 255, 204));
        JLabel lblTitulo = new JLabel("GESTIÓN DE ALIMENTOS", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(0, 153, 0));
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel central con las opciones
        JPanel panelOpciones = new JPanel(new GridLayout(1, 3, 20, 20));
        panelOpciones.setBackground(new Color(204, 255, 204));

        JButton btnFrutasVerduras = new JButton("Frutas y Verduras");
        btnFrutasVerduras.setFont(new Font("Arial", Font.BOLD, 16));
        btnFrutasVerduras.setBackground(Color.WHITE);
        btnFrutasVerduras.setIcon(new ImageIcon(getClass().getResource("/images/comida-sana.png"))); // Ajusta el icono según corresponda
        panelOpciones.add(btnFrutasVerduras);

        JButton btnGrasas = new JButton("Grasas");
        btnGrasas.setFont(new Font("Arial", Font.BOLD, 16));
        btnGrasas.setBackground(Color.WHITE);
        btnGrasas.setIcon(new ImageIcon(getClass().getResource("/images/dieta-cetogenica.png"))); // Ajusta el icono según corresponda
        panelOpciones.add(btnGrasas);

        JButton btnCarbohidratos = new JButton("Carbohidratos");
        btnCarbohidratos.setFont(new Font("Arial", Font.BOLD, 16));
        btnCarbohidratos.setBackground(Color.WHITE);
        btnCarbohidratos.setIcon(new ImageIcon(getClass().getResource("/images/carbohidratos.png"))); // Ajusta el icono según corresponda
        panelOpciones.add(btnCarbohidratos);

        add(panelOpciones, BorderLayout.CENTER);

        // Panel inferior con el logo
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(204, 255, 204));
        JLabel lblLogo = new JLabel("Opciones", JLabel.CENTER);
        lblLogo.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogo.setForeground(new Color(0, 153, 0));
        panelInferior.add(lblLogo);
        add(panelInferior, BorderLayout.SOUTH);

        // Añadir eventos a los botones según sea necesario
        btnFrutasVerduras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ir al frame de tabla frutas y verduras
                new TablaFrutasVerdurasFrame(sistemaGestionAlimentos).setVisible(true);
            }
        });

        btnGrasas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ir al frame de tabla grasas
                new TablaGrasasFrame(sistemaGestionAlimentos).setVisible(true);
            }
        });

        btnCarbohidratos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para gestionar carbohidratos
                new TablaCarbohidratosFrame(sistemaGestionAlimentos).setVisible(true);
            }
        });
    }
}
