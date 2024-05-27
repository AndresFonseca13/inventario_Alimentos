import clases.SistemaGestionAlimentos;
import clases.SistemaGestionUsuarios;
import views.LoginFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SistemaGestionUsuarios sistemaGestionUsuarios = new SistemaGestionUsuarios();
                SistemaGestionAlimentos sistemaGestionAlimentos = new SistemaGestionAlimentos();
                new LoginFrame(sistemaGestionUsuarios, sistemaGestionAlimentos).setVisible(true);
            }
        });
    }
}
