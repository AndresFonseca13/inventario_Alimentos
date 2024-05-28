package clases;

import interfaces.AlimentoInterface;
import lombok.Getter;
import lombok.Setter;

// La anotación @Getter de Lombok genera automáticamente los métodos getter para cada campo.
// La anotación @Setter de Lombok genera automáticamente los métodos setter para cada campo.
@Getter
@Setter

// La clase Grasas extiende de la clase Alimentos e implementa la interfaz AlimentoInterface.
// Esta clase representa un tipo específico de alimento: las grasas.
public class Grasas extends Alimentos implements AlimentoInterface {

    // Tipo de grasa
    private String tipoGrasa;

    // Origen de la grasa
    private String origen;

    // Constructor de la clase Grasas
    // Inicializa un nuevo objeto Grasas con los valores proporcionados
    public Grasas(String nombre, String textura, String sabor, String tamanho, String aroma, String forma, int calorias, double precio, String tipoGrasa, String origen) {
        super(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio);
        this.tipoGrasa = tipoGrasa;
        this.origen = origen;
    }

    // Método que implementa la interfaz AlimentoInterface
    // Devuelve una cadena de texto con la información detallada de la grasa
    @Override
    public String mostrarInformacionDetallada() {
        return "Nombre: " + nombre + "\n" +
                "Textura: " + textura + "\n" +
                "Sabor: " + sabor + "\n" +
                "Tamaño: " + tamanho + "\n" +
                "Aroma: " + aroma + "\n" +
                "Forma: " + forma + "\n" +
                "Calorias: " + calorias + "\n" +
                "Precio: " + precio + "\n" +
                "Tipo de grasa: " + tipoGrasa + "\n" +
                "Origen: " + origen + "\n";
    }
}
