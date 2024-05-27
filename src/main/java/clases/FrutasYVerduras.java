package clases;

import interfaces.AlimentoInterface;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FrutasYVerduras extends Alimentos implements AlimentoInterface {

    private String color;

    private boolean esDeTemporada;

    public FrutasYVerduras(String nombre, String textura, String sabor, String tamanho, String aroma, String forma, int calorias, double precio, String color, boolean esDeTemporada) {
        super(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio);
        this.color = color;
        this.esDeTemporada = esDeTemporada;
    }


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
}
