package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorExclusividad;
import edu.fiuba.algo3.modelo.puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.puntos.PuntoNulo;
import edu.fiuba.algo3.modelo.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorExclusividadTest {

    Jugador jugador;
    Puntuacion puntos;

    @BeforeEach
    public void setUp(){
        jugador = new Jugador("Prueba");
        puntos = new Puntuacion();
    }

    @Test
    public void test01CreoUnaPuntuacionLeAgrego10PuntosPositivosYLeAplicoElMultiplicadorDeExclusividadAhoraTengo20(){
        for (int i=0;i<10;i++) {
            puntos.agregarPunto(new PuntoPositivo());
        }
        MultiplicadorExclusividad unMultiplicador = new MultiplicadorExclusividad();

        puntos = unMultiplicador.usarEnPuntos(puntos,jugador);

        assertEquals(20,puntos.representar());
    }

    @Test
    public void test02CreoUnaPuntuacionLeAgrego5PuntosNegativosYLeAplicoElMultiplicadorDeExclusividadAhoraTengo10Negativos(){
        for (int i=0;i<5;i++) {
            puntos.agregarPunto(new PuntoNegativo());
        }
        MultiplicadorExclusividad unMultiplicador = new MultiplicadorExclusividad();

        puntos = unMultiplicador.usarEnPuntos(puntos,jugador);

        assertEquals(-10,puntos.representar());
    }

    @Test
    public void test03CreoUnaPuntuacionLeAgrego10PuntosNulosYLeAplicoElMultiplicadorDeExclusividadAhoraTengo0Puntos(){
        for (int i=0;i<10;i++) {
            puntos.agregarPunto(new PuntoNulo());
        }
        MultiplicadorExclusividad unMultiplicador = new MultiplicadorExclusividad();

        unMultiplicador.usarEnPuntos(puntos,jugador);

        assertEquals(0,puntos.representar());
    }
}
