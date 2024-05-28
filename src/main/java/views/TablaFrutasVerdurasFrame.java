package views;

import clases.FrutasYVerduras;
import clases.SistemaGestionAlimentos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class TablaFrutasVerdurasFrame extends JFrame {
    private SistemaGestionAlimentos sistemaGestionAlimentos;
    private JTable table;

    // Se crea un constructor que recibe un objeto de la clase SistemaGestionAlimentos
    public TablaFrutasVerdurasFrame(SistemaGestionAlimentos sistemaGestionAlimentos) {
        this.sistemaGestionAlimentos = sistemaGestionAlimentos;

        setTitle("Tabla de Frutas y Verduras");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(204, 255, 204));

        // Crear el título
        JLabel titulo = new JLabel("Frutas Y Verduras", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        // Crear la imagen
        ImageIcon imagenIcon = (new ImageIcon(getClass().getResource("/images/comida-sana.png"))); // Asegúrate de que la ruta de la imagen sea correcta
        JLabel imagen = new JLabel(imagenIcon);

        // Crear un panel para el título y la imagen y agregarlos
        JPanel panelTituloImagen = new JPanel();
        panelTituloImagen.setLayout(new BoxLayout(panelTituloImagen, BoxLayout.Y_AXIS));
        panelTituloImagen.add(titulo);
        panelTituloImagen.add(imagen);

        // Agregar el panel al JFrame
        add(panelTituloImagen, BorderLayout.NORTH);

        // Columnas de la tabla
        String[] columnas = {"Nombre", "Textura", "Sabor", "Tamaño", "Aroma", "Forma", "Calorías", "Precio", "Color", "Es de Temporada"};

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
            RegistroFrutasVerdurasFrame registroFrutasVerdurasFrame = new RegistroFrutasVerdurasFrame(sistemaGestionAlimentos);
            registroFrutasVerdurasFrame.setVisible(true);
            registroFrutasVerdurasFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                    actualizarTabla();
                }
            });
        });

        // Crear los botones
        JButton btnEliminar = new JButton("Eliminar alimento");
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 18));
        btnEliminar.setBackground(new Color(0, 153, 0));
        btnEliminar.setForeground(Color.WHITE);
        // Agregar ActionListener al botón de eliminar
        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = table.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una fila");
            } else {
                String nombre = (String) table.getValueAt(filaSeleccionada, 0);
                sistemaGestionAlimentos.eliminarFrutaVerdura(nombre);
                actualizarTabla();
            }
        });

        JButton btnEditar = new JButton("Editar alimento");
        btnEditar.setFont(new Font("Arial", Font.BOLD, 18));
        btnEditar.setBackground(new Color(0, 153, 0));
        btnEditar.setForeground(Color.WHITE);
        // Agregar ActionListener al botón de editar
        btnEditar.addActionListener(e -> {
            int filaSeleccionada = table.getSelectedRow();
            if (filaSeleccionada != -1) {
                String nombreOriginal = (String) table.getValueAt(filaSeleccionada, 0);
                FrutasYVerduras frutaVerdura = sistemaGestionAlimentos.obtenerFrutaVerdura(nombreOriginal);

                JTextField campoNombre = new JTextField(frutaVerdura.getNombre());
                JTextField campoTextura = new JTextField(frutaVerdura.getTextura());
                JTextField campoSabor = new JTextField(frutaVerdura.getSabor());
                JTextField campoTamanho = new JTextField(frutaVerdura.getTamanho());
                JTextField campoAroma = new JTextField(frutaVerdura.getAroma());
                JTextField campoForma = new JTextField(frutaVerdura.getForma());
                JTextField campoCalorias = new JTextField(String.valueOf(frutaVerdura.getCalorias()));
                JTextField campoPrecio = new JTextField(String.valueOf(frutaVerdura.getPrecio()));
                JTextField campoColor = new JTextField(frutaVerdura.getColor());
                JCheckBox campoEsDeTemporada = new JCheckBox();
                campoEsDeTemporada.setSelected(frutaVerdura.isEsDeTemporada());

                Object[] campos = {
                        "Nombre:", campoNombre,
                        "Textura:", campoTextura,
                        "Sabor:", campoSabor,
                        "Tamaño:", campoTamanho,
                        "Aroma:", campoAroma,
                        "Forma:", campoForma,
                        "Calorías:", campoCalorias,
                        "Precio:", campoPrecio,
                        "Color:", campoColor,
                        "Es de temporada:", campoEsDeTemporada
                };

                int opcion = JOptionPane.showConfirmDialog(null, campos, "Editar Alimento", JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {
                    String nombre = campoNombre.getText();
                    String textura = campoTextura.getText();
                    String sabor = campoSabor.getText();
                    String tamanho = campoTamanho.getText();
                    String aroma = campoAroma.getText();
                    String forma = campoForma.getText();
                    int calorias = Integer.parseInt(campoCalorias.getText());
                    double precio = Double.parseDouble(campoPrecio.getText());
                    String color = campoColor.getText();
                    boolean esDeTemporada = campoEsDeTemporada.isSelected();

                    FrutasYVerduras nuevaFrutaVerdura = new FrutasYVerduras(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio, color, esDeTemporada);
                    sistemaGestionAlimentos.editarFrutaVerdura(nombreOriginal, nuevaFrutaVerdura);
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

        List<FrutasYVerduras> frutasYVerduras = sistemaGestionAlimentos.obtenerFrutasYVerduras();
        for (FrutasYVerduras frutaVerdura : frutasYVerduras) {
            Object[] rowData = {
                    frutaVerdura.getNombre(),
                    frutaVerdura.getTextura(),
                    frutaVerdura.getSabor(),
                    frutaVerdura.getTamanho(),
                    frutaVerdura.getAroma(),
                    frutaVerdura.getForma(),
                    frutaVerdura.getCalorias(),
                    frutaVerdura.getPrecio(),
                    frutaVerdura.getColor(),
                    frutaVerdura.isEsDeTemporada()
            };
            tableModel.addRow(rowData);
        }
    }
}
