package clases;

import java.util.ArrayList;
import java.util.List;

// La clase SistemaGestionAlimentos se encarga de gestionar los alimentos en el sistema.
// Esta clase contiene listas para almacenar diferentes tipos de alimentos: frutas y verduras, grasas e hidratos de carbono.
public class SistemaGestionAlimentos {
    // Listas para almacenar los diferentes tipos de alimentos
    private final List<FrutasYVerduras> frutasYVerduras;
    private final List<Grasas> grasas;
    private final List<HidratosDeCarbono> hidratosDeCarbonos;

    // Constructor de la clase SistemaGestionAlimentos
    // Inicializa las listas de alimentos
    public SistemaGestionAlimentos() {
        frutasYVerduras = new ArrayList<>();
        grasas = new ArrayList<>();
        hidratosDeCarbonos = new ArrayList<>();
    }

    // Métodos para agregar alimentos a las listas correspondientes
    public void agregarFrutaVerdura(FrutasYVerduras frutaVerdura) {
        frutasYVerduras.add(frutaVerdura);
    }

    public void agregarGrasa(Grasas grasa) {
        grasas.add(grasa);
    }

    public void agregarHidratoDeCarbono(HidratosDeCarbono hidratoDeCarbono) {
        hidratosDeCarbonos.add(hidratoDeCarbono);
    }

    // Métodos para obtener las listas de alimentos
    public List<FrutasYVerduras> obtenerFrutasYVerduras() {
        return frutasYVerduras;
    }

    public List<Grasas> obtenerGrasas() {
        return grasas;
    }

    public List<HidratosDeCarbono> obtenerHidratosDeCarbonos() {
        return hidratosDeCarbonos;
    }

    // Métodos para obtener un alimento específico por su nombre
    public FrutasYVerduras obtenerFrutaVerdura(String nombre) {
        for (FrutasYVerduras frutaVerdura : frutasYVerduras) {
            if (frutaVerdura.getNombre().equals(nombre)) {
                return frutaVerdura;
            }
        }
        return null;
    }

    public Grasas obtenerGrasa(String nombre) {
        for (Grasas grasa : grasas) {
            if (grasa.getNombre().equals(nombre)) {
                return grasa;
            }
        }
        return null;
    }

    public HidratosDeCarbono obtenerCarbohidrato(String nombre){
        for (HidratosDeCarbono carbono : hidratosDeCarbonos) {
            if (carbono.getNombre().equals(nombre)) {
                return carbono;
            }
        }
        return null;
    }

    // Métodos para eliminar un alimento específico por su nombre
    public void eliminarFrutaVerdura(String nombre) {
        FrutasYVerduras frutaVerdura = obtenerFrutaVerdura(nombre);
        if (frutaVerdura != null) {
            frutasYVerduras.remove(frutaVerdura);
        }
    }

    public void eliminarGrasa(String nombre) {
        Grasas grasa = obtenerGrasa(nombre);
        if (grasa != null) {
            grasas.remove(grasa);
        }
    }

    public void eliminarCarbohidrato(String nombre){
        HidratosDeCarbono carbohidrato = obtenerCarbohidrato(nombre);
        if (carbohidrato != null) {
            hidratosDeCarbonos.remove(carbohidrato);
        }
    }

    // Métodos para editar un alimento específico
    public void editarFrutaVerdura(String nombreOriginal, FrutasYVerduras nuevaFrutaVerdura) {
        FrutasYVerduras frutaVerdura = obtenerFrutaVerdura(nombreOriginal);
        if (frutaVerdura != null) {
            frutasYVerduras.remove(frutaVerdura);
            frutasYVerduras.add(nuevaFrutaVerdura);
        }
    }

    public void editarGrasa(String nombreOriginal, Grasas nuevaGrasa) {
        Grasas grasa = obtenerGrasa(nombreOriginal);
        if (grasa != null) {
            grasas.remove(grasa);
            grasas.add(nuevaGrasa); // Agregar la nueva grasa en lugar de la grasa original
        }
    }

    public void editarCarbohidrato(String nombreOriginal, HidratosDeCarbono nuevoCarbohidrato){
        HidratosDeCarbono carbohidrato = obtenerCarbohidrato(nombreOriginal);
        if (carbohidrato != null) {
            hidratosDeCarbonos.remove(carbohidrato);
            hidratosDeCarbonos.add(nuevoCarbohidrato);
        }
    }
}
