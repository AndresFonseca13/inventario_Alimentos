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
        add(btnRegistrar, BorderLayout.SOUTH);

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
                sistemaGestionAlimentos.eliminarGrasa(null);
                actualizarTabla();
            }
        });
        add(btnEliminar, BorderLayout.NORTH);
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
