package edu.fiuba.algo3.modelo.desordenador;

import java.util.ArrayList;
import java.util.Collections;

public class CriterioDesorden implements CriterioOrdenamiento {

    @Override
    public void desordenar(ArrayList listaADesordenar) {
        Collections.shuffle(listaADesordenar);
    }
}
