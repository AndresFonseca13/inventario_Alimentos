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

    public TablaFrutasVerdurasFrame(SistemaGestionAlimentos sistemaGestionAlimentos) {
        this.sistemaGestionAlimentos = sistemaGestionAlimentos;

        setTitle("Tabla de Frutas y Verduras");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(204, 255, 204));

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
        add(btnRegistrar, BorderLayout.SOUTH);
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
