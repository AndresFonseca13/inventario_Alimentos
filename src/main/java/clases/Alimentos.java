package clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Alimentos {

    String nombre;

    String textura;

    String sabor;

    String tamanho;

    String aroma;

    String forma;

    int calorias;

    double precio;

    public Alimentos(String nombre, String textura, String sabor, String tamanho, String aroma, String forma, int calorias, double precio) {
        this.nombre = nombre;
        this.textura = textura;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.aroma = aroma;
        this.forma = forma;
        this.calorias = calorias;
        this.precio = precio;
    }



}
