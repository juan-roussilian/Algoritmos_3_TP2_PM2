package edu.fiuba.algo3.modelo.preguntas.orderedChoice;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaComparable;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.modelo.respuestas.RespuestaComparable;
import edu.fiuba.algo3.modelo.respuestas.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import java.util.ArrayList;

public class OrderedChoice extends Pregunta implements PreguntaComparable {

    private RespuestaOrderedChoice respuestaCorrecta;
    static final int CANT_RESPUESTAS_CORRECTAS_TOTALES = 1;

    public OrderedChoice(String enunciado, RespuestaOrderedChoice respuestaCorrecta) {
        super(enunciado,new PuntajeClasico());
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public Resultado responder(Respuesta respuestasJugador, Jugador unJugador) {
        return respuestasJugador.evaluarEnBaseAPregunta(this,unJugador);
    }

    @Override
    public ArrayList<OpcionSimple> respuestasPregunta() {
        return (new ArrayList<>(respuestaCorrecta.respuestas()));
    }

    @Override
    public Resultado responder(RespuestaComparable respuestaJugador, Jugador unJugador) {
        Resultado unResultado = puntaje.obtenerResultado(CANT_RESPUESTAS_CORRECTAS_TOTALES, unJugador);
        respuestaJugador.compararContra(respuestaCorrecta, unResultado);
        return unResultado;
    }

}
