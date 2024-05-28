package views;

import clases.Grasas;
import clases.SistemaGestionAlimentos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroGrasasFrame extends JFrame {
    private JTextField txtNombre;
    private JTextField txtTextura;
    private JTextField txtSabor;
    private JTextField txtTamanho;
    private JTextField txtAroma;
    private JTextField txtForma;
    private JTextField txtCalorias;
    private JTextField txtPrecio;
    private JTextField txtTipoGrasa;
    private JTextField txtOrigen;
    private JButton btnRegistrar;
    private SistemaGestionAlimentos sistemaGestionAlimentos;

    public RegistroGrasasFrame(SistemaGestionAlimentos sistemaGestionAlimentos) {
        this.sistemaGestionAlimentos = sistemaGestionAlimentos;

        setTitle("Registrar Grasa");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(new Color(204, 255, 204));
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Componentes del formulario
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(20);
        JLabel lblTextura = new JLabel("Textura:");
        txtTextura = new JTextField(20);
        JLabel lblSabor = new JLabel("Sabor:");
        txtSabor = new JTextField(20);
        JLabel lblTamanho = new JLabel("Tamaño:");
        txtTamanho = new JTextField(20);
        JLabel lblAroma = new JLabel("Aroma:");
        txtAroma = new JTextField(20);
        JLabel lblForma = new JLabel("Forma:");
        txtForma = new JTextField(20);
        JLabel lblCalorias = new JLabel("Calorías:");
        txtCalorias = new JTextField(20);
        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField(20);
        JLabel lblTipoGrasa = new JLabel("Tipo de Grasa:");
        txtTipoGrasa = new JTextField(20);
        JLabel lblOrigen = new JLabel("Origen:");
        txtOrigen = new JTextField(20);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegistrar.setBackground(new Color(0, 153, 0));
        btnRegistrar.setForeground(Color.WHITE);

        // Agregar componentes al formulario
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(lblNombre, constraints);
        constraints.gridx = 1;
        add(txtNombre, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(lblTextura, constraints);
        constraints.gridx = 1;
        add(txtTextura, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        add(lblSabor, constraints);
        constraints.gridx = 1;
        add(txtSabor, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        add(lblTamanho, constraints);
        constraints.gridx = 1;
        add(txtTamanho, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        add(lblAroma, constraints);
        constraints.gridx = 1;
        add(txtAroma, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        add(lblForma, constraints);
        constraints.gridx = 1;
        add(txtForma, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        add(lblCalorias, constraints);
        constraints.gridx = 1;
        add(txtCalorias, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        add(lblPrecio, constraints);
        constraints.gridx = 1;
        add(txtPrecio, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        add(lblTipoGrasa, constraints);
        constraints.gridx = 1;
        add(txtTipoGrasa, constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        add(lblOrigen, constraints);
        constraints.gridx = 1;
        add(txtOrigen, constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        constraints.gridwidth = 2;
        add(btnRegistrar, constraints);

        // Evento del botón de registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String textura = txtTextura.getText();
                    String sabor = txtSabor.getText();
                    String tamanho = txtTamanho.getText();
                    String aroma = txtAroma.getText();
                    String forma = txtForma.getText();
                    int calorias = Integer.parseInt(txtCalorias.getText());
                    double precio = Double.parseDouble(txtPrecio.getText());
                    String tipoGrasa = txtTipoGrasa.getText();
                    String origen = txtOrigen.getText();

                    Grasas nuevaGrasa = new Grasas(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio, tipoGrasa, origen);

                    // Mostrar la información detallada del nuevo alimento en un cuadro de diálogo
                    String informacionDetallada = nuevaGrasa.mostrarInformacionDetallada();
                    int opcion = JOptionPane.showConfirmDialog(RegistroGrasasFrame.this, "Estás seguro de registrar esta nueva grasa?\n\n" + informacionDetallada, "Confirmar registro", JOptionPane.OK_CANCEL_OPTION);

                    if (opcion == JOptionPane.OK_OPTION) {
                        sistemaGestionAlimentos.agregarGrasa(nuevaGrasa);
                        JOptionPane.showMessageDialog(RegistroGrasasFrame.this, "Grasa registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RegistroGrasasFrame.this, "Por favor, ingrese valores válidos para calorías y precio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
