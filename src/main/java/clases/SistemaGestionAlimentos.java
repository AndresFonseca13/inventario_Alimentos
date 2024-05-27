package clases;

import java.util.ArrayList;
import java.util.List;

public class SistemaGestionAlimentos {
    private List<FrutasYVerduras> frutasYVerduras;
    private List<Grasas> grasas;
    private List<HidratosDeCarbono> hidratosDeCarbonos;

    public SistemaGestionAlimentos() {
        frutasYVerduras = new ArrayList<>();
        grasas = new ArrayList<>();
        hidratosDeCarbonos = new ArrayList<>();

    }

    public void agregarFrutaVerdura(FrutasYVerduras frutaVerdura) {
        frutasYVerduras.add(frutaVerdura);
    }

    public List<FrutasYVerduras> obtenerFrutasYVerduras() {
        return frutasYVerduras;
    }

    public void agregarGrasa(Grasas grasa) {
        grasas.add(grasa);
    }

    public List<Grasas> obtenerGrasas() {
        return grasas;
    }

    public void agregarHidratoDeCarbono(HidratosDeCarbono hidratoDeCarbono) {
        hidratosDeCarbonos.add(hidratoDeCarbono);
    }

    public List<HidratosDeCarbono> obtenerHidratosDeCarbonos() {
        return hidratosDeCarbonos;
    }
}
