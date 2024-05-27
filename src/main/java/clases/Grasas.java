package clases;

import interfaces.AlimentoInterface;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grasas extends Alimentos implements AlimentoInterface {

    private String tipoGrasa;

    private String origen;

    public Grasas(String nombre, String textura, String sabor, String tamanho, String aroma, String forma, int calorias, double precio, String tipoGrasa, String origen) {
        super(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio);
        this.tipoGrasa = tipoGrasa;
        this.origen = origen;
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
                "Tipo de grasa: " + tipoGrasa + "\n" +
                "Origen: " + origen + "\n";
    }
}
