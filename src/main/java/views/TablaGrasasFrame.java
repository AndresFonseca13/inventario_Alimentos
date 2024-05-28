package views;

import clases.Grasas;
import clases.SistemaGestionAlimentos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class TablaGrasasFrame extends JFrame {
    private SistemaGestionAlimentos sistemaGestionAlimentos;
    private JTable table;

    public TablaGrasasFrame(SistemaGestionAlimentos sistemaGestionAlimentos) {
        this.sistemaGestionAlimentos = sistemaGestionAlimentos;

        setTitle("Tabla de Grasas");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear el título
        JLabel titulo = new JLabel("Grasas", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        // Crear la imagen
        ImageIcon imagenIcon = (new ImageIcon(getClass().getResource("/images/dieta-cetogenica.png"))); // Asegúrate de que la ruta de la imagen sea correcta
        JLabel imagen = new JLabel(imagenIcon);

        // Crear un panel para el título y la imagen y agregarlos
        JPanel panelTituloImagen = new JPanel();
        panelTituloImagen.setLayout(new BoxLayout(panelTituloImagen, BoxLayout.Y_AXIS));
        panelTituloImagen.add(titulo);
        panelTituloImagen.add(imagen);

        // Agregar el panel al JFrame
        add(panelTituloImagen, BorderLayout.NORTH);

        // Columnas de la tabla
        String[] columnas = {"Nombre", "Textura", "Sabor", "Tamaño", "Aroma", "Forma", "Calorías", "Precio", "Tipo de Grasa", "Origen"};

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
            RegistroGrasasFrame registroGrasasFrame = new RegistroGrasasFrame(sistemaGestionAlimentos);
            registroGrasasFrame.setVisible(true);
            registroGrasasFrame.addWindowListener(new java.awt.event.WindowAdapter() {
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
                JOptionPane.showMessageDialog(this, "Por favor seleccione una fila");
            } else {
                String nombre = (String) table.getValueAt(filaSeleccionada, 0);
                // Encuentra la grasa por el nombre y la elimina
                sistemaGestionAlimentos.eliminarGrasa(nombre);
                actualizarTabla();
            }
        });

        JButton btnEditar = new JButton("Editar alimento");
        btnEditar.setFont(new Font("Arial", Font.BOLD, 18));
        btnEditar.setBackground(new Color(0, 153, 0));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.addActionListener(e -> {
            int filaSeleccionada = table.getSelectedRow();
            if (filaSeleccionada != -1) {
                String nombreOriginal = (String) table.getValueAt(filaSeleccionada, 0);
                Grasas grasa = sistemaGestionAlimentos.obtenerGrasa(nombreOriginal);

                JTextField campoNombre = new JTextField(grasa.getNombre());
                JTextField campoTextura = new JTextField(grasa.getTextura());
                JTextField campoSabor = new JTextField(grasa.getSabor());
                JTextField campoTamanho = new JTextField(grasa.getTamanho());
                JTextField campoAroma = new JTextField(grasa.getAroma());
                JTextField campoForma = new JTextField(grasa.getForma());
                JTextField campoCalorias = new JTextField(String.valueOf(grasa.getCalorias()));
                JTextField campoPrecio = new JTextField(String.valueOf(grasa.getPrecio()));
                JTextField campoTipoGrasa = new JTextField(grasa.getTipoGrasa());
                JTextField campoOrigen = new JTextField(grasa.getOrigen());

                Object[] campos = {
                        "Nombre:", campoNombre,
                        "Textura:", campoTextura,
                        "Sabor:", campoSabor,
                        "Tamaño:", campoTamanho,
                        "Aroma:", campoAroma,
                        "Forma:", campoForma,
                        "Calorías:", campoCalorias,
                        "Precio:", campoPrecio,
                        "Tipo de Grasa:", campoTipoGrasa,
                        "Origen:", campoOrigen
                };

                int opcion = JOptionPane.showConfirmDialog(null, campos, "Editar Grasa", JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {
                    String nombre = campoNombre.getText();
                    String textura = campoTextura.getText();
                    String sabor = campoSabor.getText();
                    String tamanho = campoTamanho.getText();
                    String aroma = campoAroma.getText();
                    String forma = campoForma.getText();
                    int calorias = Integer.parseInt(campoCalorias.getText());
                    double precio = Double.parseDouble(campoPrecio.getText());
                    String tipoGrasa = campoTipoGrasa.getText();
                    String origen = campoOrigen.getText();

                    Grasas nuevaGrasa = new Grasas(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio, tipoGrasa, origen);
                    sistemaGestionAlimentos.editarGrasa(nombreOriginal, nuevaGrasa);
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

        List<Grasas> grasas = sistemaGestionAlimentos.obtenerGrasas();
        for (Grasas grasa : grasas) {
            Object[] rowData = {
                    grasa.getNombre(),
                    grasa.getTextura(),
                    grasa.getSabor(),
                    grasa.getTamanho(),
                    grasa.getAroma(),
                    grasa.getForma(),
                    grasa.getCalorias(),
                    grasa.getPrecio(),
                    grasa.getTipoGrasa(),
                    grasa.getOrigen()
            };
            tableModel.addRow(rowData);
        }
    }
}
