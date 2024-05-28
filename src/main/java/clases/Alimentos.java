package clases;


import lombok.Getter;
import lombok.Setter;

// La anotación @Getter de Lombok genera automáticamente los métodos getter para cada campo.
// La anotación @Setter de Lombok genera automáticamente los métodos setter para cada campo.
@Getter
@Setter

// La clase Alimentos es una clase abstracta que representa un alimento genérico.
// Esta clase contiene los campos y métodos comunes a todos los alimentos.
public abstract class Alimentos {

    // Nombre del alimento
    String nombre;

    // Textura del alimento
    String textura;

    // Sabor del alimento
    String sabor;

    // Tamaño del alimento
    String tamanho;

    // Aroma del alimento
    String aroma;

    // Forma del alimento
    String forma;

    // Calorías del alimento
    int calorias;

    // Precio del alimento
    double precio;

    // Constructor de la clase Alimentos
    // Inicializa un nuevo objeto Alimentos con los valores proporcionados
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
