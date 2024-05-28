package views;

import clases.Grasas;
import clases.HidratosDeCarbono;
import clases.SistemaGestionAlimentos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TablaCarbohidratosFrame extends JFrame {
    private SistemaGestionAlimentos sistemaGestionAlimentos;
    private JTable table;

    public TablaCarbohidratosFrame(SistemaGestionAlimentos sistemaGestionAlimentos) {
        this.sistemaGestionAlimentos = sistemaGestionAlimentos;

        setTitle("Tabla de Carbohidratos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear el título
        JLabel titulo = new JLabel("Carbohidratos", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        // Crear la imagen
        ImageIcon imagenIcon = (new ImageIcon(getClass().getResource("/images/carbohidratos.png"))); // Asegúrate de que la ruta de la imagen sea correcta
        JLabel imagen = new JLabel(imagenIcon);

        // Crear un panel para el título y la imagen y agregarlos
        JPanel panelTituloImagen = new JPanel();
        panelTituloImagen.setLayout(new BoxLayout(panelTituloImagen, BoxLayout.Y_AXIS));
        panelTituloImagen.add(titulo);
        panelTituloImagen.add(imagen);

        // Agregar el panel al JFrame
        add(panelTituloImagen, BorderLayout.NORTH);

        // Columnas de la tabla
        String[] columnas = {"Nombre", "Textura", "Sabor", "Tamaño", "Aroma", "Forma", "Calorías", "Precio", "Indice Glucemico", "Es Integral"};

        // Modelo de la tabla
        DefaultTableModel tableModel = new DefaultTableModel(columnas, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        // Llenar la tabla con los datos
        actualizarTabla();

        // Panel de la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Boton para registrar un nuevo alimento
        JButton btnRegistrar = new JButton("Registrar nuevo alimento");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegistrar.setBackground(new Color(0, 153, 0));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.addActionListener(e -> {
            RegistroCarbohidratosFrame registroCarbohidratosFrame = new RegistroCarbohidratosFrame(sistemaGestionAlimentos);
            registroCarbohidratosFrame.setVisible(true);
            registroCarbohidratosFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    actualizarTabla();
                }
            });
        });

        JButton btnEliminar = new JButton("Eliminar alimento");
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 18));
        btnEliminar.setBackground(new Color(0, 153, 0));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = table.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un alimento a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nombre = (String) table.getValueAt(filaSeleccionada, 0);
            sistemaGestionAlimentos.eliminarCarbohidrato(nombre);
            actualizarTabla();
        });

        JButton btnEditar = new JButton("Editar alimento");
        btnEditar.setFont(new Font("Arial", Font.BOLD, 18));
        btnEditar.setBackground(new Color(0, 153, 0));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.addActionListener(e -> {
            int filaSeleccionada = table.getSelectedRow();
            if (filaSeleccionada != -1) {
                String nombreOriginal = (String) table.getValueAt(filaSeleccionada, 0);
                HidratosDeCarbono hidratosDeCarbono = sistemaGestionAlimentos.obtenerCarbohidrato(nombreOriginal);

                JTextField campoNombre = new JTextField(hidratosDeCarbono.getNombre());
                JTextField campoTextura = new JTextField(hidratosDeCarbono.getTextura());
                JTextField campoSabor = new JTextField(hidratosDeCarbono.getSabor());
                JTextField campoTamanho = new JTextField(hidratosDeCarbono.getTamanho());
                JTextField campoAroma = new JTextField(hidratosDeCarbono.getAroma());
                JTextField campoForma = new JTextField(hidratosDeCarbono.getForma());
                JTextField campoCalorias = new JTextField(String.valueOf(hidratosDeCarbono.getCalorias()));
                JTextField campoPrecio = new JTextField(String.valueOf(hidratosDeCarbono.getPrecio()));
                JTextField campoIndiceGlucemico = new JTextField(String.valueOf(hidratosDeCarbono.getIndiceGlucemico()));
                JCheckBox  checkBoxEsIntegral  = new JCheckBox();

                Object[] campos = {
                        "Nombre:", campoNombre,
                        "Textura:", campoTextura,
                        "Sabor:", campoSabor,
                        "Tamaño:", campoTamanho,
                        "Aroma:", campoAroma,
                        "Forma:", campoForma,
                        "Calorías:", campoCalorias,
                        "Precio:", campoPrecio,
                        "Campo Indice Glucemico:", campoIndiceGlucemico,
                        "Es Integral:", checkBoxEsIntegral
                };

                int opcion = JOptionPane.showConfirmDialog(null, campos, "Editar Carbohidrato", JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {
                    String nombre = campoNombre.getText();
                    String textura = campoTextura.getText();
                    String sabor = campoSabor.getText();
                    String tamanho = campoTamanho.getText();
                    String aroma = campoAroma.getText();
                    String forma = campoForma.getText();
                    int calorias = Integer.parseInt(campoCalorias.getText());
                    double precio = Double.parseDouble(campoPrecio.getText());
                    int indiceGlucemico = Integer.parseInt(campoIndiceGlucemico.getText());
                    boolean esIntegral = checkBoxEsIntegral.isSelected();

                    HidratosDeCarbono nuevoHidrato = new HidratosDeCarbono(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio, indiceGlucemico, esIntegral );
                    sistemaGestionAlimentos.editarCarbohidrato(nombreOriginal, nuevoHidrato);
                    actualizarTabla();
                }
            }
        });

        // Crear un JPanel para los botones y agregar los botones a él
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnEditar);

        // Agregar el JPanel al JFrame
        add(panelBotones, BorderLayout.SOUTH);
    }

    public void actualizarTabla() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0); // Limpiar la tabla

        List<HidratosDeCarbono> hidratosDeCarbonos = sistemaGestionAlimentos.obtenerHidratosDeCarbonos();
        for (HidratosDeCarbono hidratoDeCarbono : hidratosDeCarbonos) {
            Object[] rowData = {
                    hidratoDeCarbono.getNombre(),
                    hidratoDeCarbono.getTextura(),
                    hidratoDeCarbono.getSabor(),
                    hidratoDeCarbono.getTamanho(),
                    hidratoDeCarbono.getAroma(),
                    hidratoDeCarbono.getForma(),
                    hidratoDeCarbono.getCalorias(),
                    hidratoDeCarbono.getPrecio(),
                    hidratoDeCarbono.getIndiceGlucemico(),
                    hidratoDeCarbono.isEsIntegral()
            };
            tableModel.addRow(rowData);
        }
    }
}
