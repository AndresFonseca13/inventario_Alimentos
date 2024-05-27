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
        add(btnRegistrar, BorderLayout.SOUTH);
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
