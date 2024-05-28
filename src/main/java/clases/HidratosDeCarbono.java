package clases;

import interfaces.AlimentoInterface;
import lombok.Getter;
import lombok.Setter;

// La anotación @Getter de Lombok genera automáticamente los métodos getter para cada campo.
// La anotación @Setter de Lombok genera automáticamente los métodos setter para cada campo.
@Getter
@Setter

// La clase HidratosDeCarbono extiende de la clase Alimentos e implementa la interfaz AlimentoInterface.
// Esta clase representa un tipo específico de alimento: los hidratos de carbono.
public class HidratosDeCarbono extends Alimentos implements AlimentoInterface {

    // Índice glucémico del hidrato de carbono
    private int indiceGlucemico;

    // Indica si el hidrato de carbono es integral
    private boolean esIntegral;

    // Constructor de la clase HidratosDeCarbono
    // Inicializa un nuevo objeto HidratosDeCarbono con los valores proporcionados
    public HidratosDeCarbono(String nombre, String textura, String sabor, String tamanho, String aroma, String forma, int calorias, double precio, int indiceGlucemico, boolean esIntegral) {
        super(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio);
        this.indiceGlucemico = indiceGlucemico;
        this.esIntegral = esIntegral;
    }

    // Método que implementa la interfaz AlimentoInterface
    // Devuelve una cadena de texto con la información detallada del hidrato de carbono
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
                "Indice Glucemico: " + indiceGlucemico + "\n" +
                "Es integral: " + esIntegral + "\n";
    }

    @Override
    public void comer() {
        System.out.println("Estás comiendo un alimento que es carbohidrato llamado " + this.nombre);
    }

    @Override
    public void preparar() {
        System.out.println("Estás preparando un alimento que es carbohidrato llamado " + this.nombre);
    }
}
