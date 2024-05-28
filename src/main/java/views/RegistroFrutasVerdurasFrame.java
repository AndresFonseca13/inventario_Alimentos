package views;

import clases.FrutasYVerduras;
import clases.SistemaGestionAlimentos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroFrutasVerdurasFrame extends JFrame {
    private JTextField txtNombre;
    private JTextField txtTextura;
    private JTextField txtSabor;
    private JTextField txtTamanho;
    private JTextField txtAroma;
    private JTextField txtForma;
    private JTextField txtCalorias;
    private JTextField txtPrecio;
    private JTextField txtColor;
    private JCheckBox chkEsDeTemporada;
    private JButton btnRegistrar;
    private SistemaGestionAlimentos sistemaGestionAlimentos;

    public RegistroFrutasVerdurasFrame(SistemaGestionAlimentos sistemaGestionAlimentos) {
        this.sistemaGestionAlimentos = sistemaGestionAlimentos;

        setTitle("Registrar Fruta o Verdura");
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
        JLabel lblColor = new JLabel("Color:");
        txtColor = new JTextField(20);
        JLabel lblEsDeTemporada = new JLabel("Es de temporada:");
        chkEsDeTemporada = new JCheckBox();

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
        add(lblColor, constraints);
        constraints.gridx = 1;
        add(txtColor, constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        add(lblEsDeTemporada, constraints);
        constraints.gridx = 1;
        add(chkEsDeTemporada, constraints);

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
                    String color = txtColor.getText();
                    boolean esDeTemporada = chkEsDeTemporada.isSelected();

                    FrutasYVerduras nuevaFrutaVerdura = new FrutasYVerduras(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio, color, esDeTemporada);

                    // Mostrar la información detallada del nuevo alimento en un cuadro de diálogo
                    String informacionDetallada = nuevaFrutaVerdura.mostrarInformacionDetallada();
                    int opcion = JOptionPane.showConfirmDialog(RegistroFrutasVerdurasFrame.this, "Estás seguro de registrar este nuevo alimento a la categoría de frutas y verduras?\n\n" + informacionDetallada, "Confirmar registro", JOptionPane.OK_CANCEL_OPTION);

                    if (opcion == JOptionPane.OK_OPTION) {
                        sistemaGestionAlimentos.agregarFrutaVerdura(nuevaFrutaVerdura);
                        JOptionPane.showMessageDialog(RegistroFrutasVerdurasFrame.this, "Fruta o verdura registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RegistroFrutasVerdurasFrame.this, "Por favor, ingrese valores válidos para calorías y precio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
