package clases;

import interfaces.AlimentoInterface;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HidratosDeCarbono extends Alimentos implements AlimentoInterface {

    private int indiceGlucemico;

    private boolean esIntegral;

    public HidratosDeCarbono(String nombre, String textura, String sabor, String tamanho, String aroma, String forma, int calorias, double precio, int indiceGlucemico, boolean esIntegral) {
        super(nombre, textura, sabor, tamanho, aroma, forma, calorias, precio);
        this.indiceGlucemico = indiceGlucemico;
        this.esIntegral = esIntegral;
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
                "Indice Glucemico: " + indiceGlucemico + "\n" +
                "Es integral: " + esIntegral + "\n";
    }
}
