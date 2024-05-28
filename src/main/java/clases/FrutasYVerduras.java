package clases;

import interfaces.AlimentoInterface;
import lombok.Getter;
import lombok.Setter;

// La anotación @Getter de Lombok genera automáticamente los métodos getter para cada campo.
// La anotación @Setter de Lombok genera automáticamente los métodos setter para cada campo.
@Getter
@Setter

// La clase FrutasYVerduras extiende de la clase Alimentos e implementa la interfaz AlimentoInterface.
// Esta clase representa un tipo específico de alimento: las frutas y verduras.
public class FrutasYVerduras extends Alimentos implements AlimentoInterface {

    // Color de la fruta o verdura
    private String color;

    // Indica si la fruta o verdura es de temporada
    private boolean esDeTemporada;

    // Constructor de la clase FrutasYVerduras
    // Inicializa un nuevo objeto FrutasYVerduras con los valores proporcionados
    public FrutasYVerduras(String nombre, String textura, String sabor, String tamanho, String aroma, String forma, int calorias, double precio, String color, boolean esDeTemporada) {
        super(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio);
        this.color = color;
        this.esDeTemporada = esDeTemporada;
    }

    // Método que implementa la interfaz AlimentoInterface
    // Devuelve una cadena de texto con la información detallada de la fruta o verdura
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
                "Color: " + color + "\n" +
                "Es de temporada: " + esDeTemporada + "\n";
    }

    @Override
    public void comer() {
        System.out.println("Estás comiendo una fruta o verdura llamada " + this.nombre);
    }

    @Override
    public void preparar() {
        System.out.println("Estás preparando una fruta o verdura llamada " + this.nombre);
    }
}
