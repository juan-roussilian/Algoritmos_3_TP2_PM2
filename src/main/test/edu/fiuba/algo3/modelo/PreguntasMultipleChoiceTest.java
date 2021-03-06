package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntasMultipleChoiceTest {

    Jugador jugador;

    public void setUp(){
        jugador = new Jugador("Prueba");
    }


    @Test
    public void test01CreoUnaPreguntaMultipleChoiceClasicoSeEligenLasCorrectasYDevuelveUnPunto(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("Vigilante");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1, puntosRepresentados.representar());
    }

    @Test
    public void test02CreoUnaPreguntaMultipleChoiceClasicoYSeEligenLasIncorrectasYNoDevuelvePuntos(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("Vigilante");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaCorrecta3);
        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0, puntosRepresentados.representar());
    }

    @Test
    public void test03IntentoCrearUnaPreguntaMultipleChoiceCon1RespuestaYLanzaExcepcion(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);}
        );
    }

    @Test
    public void test04CreoUnaPreguntaMultipleChoiceParcialSeEligenTresCorrectasYDevuelveTresPuntos(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("Vigilante");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);

        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(3, puntosRepresentados.representar());
    }

    @Test
    public void test05CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDevuelveDosPuntos(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("Vigilante");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);

        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(2, puntosRepresentados.representar());
    }

    @Test
    public void test06CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDosIncorrectasYNoDevuelvePuntos(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("CocaCola");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);


        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0, puntosRepresentados.representar());
    }

    @Test
    public void test07CreoUnaPreguntaMultipleChoiceParcialYSeEligen4RespuestasCorrectasYUnaIncorrectaYNoDevuelvePuntos() {


        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("Flan");
        OpcionCorrectaMultipleChoice respuestaCorrecta4 = new OpcionCorrectaMultipleChoice("Helado");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        respuestasJugador.add(respuestaCorrecta4);
        respuestasJugador.add(respuestaIncorrecta1);


        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0, puntosRepresentados.representar());
    }

    @Test
    public void test08CreoUnaPreguntaMultipleChoicePenalizableYSeEligen3RespuestasCorrectasYDevuelve3Puntos() {

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("Flan");
        OpcionCorrectaMultipleChoice respuestaCorrecta4 = new OpcionCorrectaMultipleChoice("Helado");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);

        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(3, puntosRepresentados.representar());
    }

    @Test
    public void test09CreoUnaPreguntaMultipleChoicePenalizableYSeEligenRespuestas2IncorrectasYDevuelve2PuntosNegativos() {

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("Flan");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);


        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(-2, puntosRepresentados.representar());
    }

    @Test
    public void test10CreoUnaPreguntaMultipleChoicePenalizableYSeEligen3RespuestasCorrectasY2IncorrectaYDevuelve1Punto() {

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("Flan");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);


        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1, puntosRepresentados.representar());
    }

    @Test
    public void test11CreoUnaPreguntaMultipleChoicePenalizableYSeEligen2RespuestasCorrectasY3IncorrectasYDevuelve1PuntoNegativo() {

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");


        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);
        respuestasJugador.add(respuestaIncorrecta3);

        RespuestaMultipleChoice respuestaMultipleChoice = new RespuestaMultipleChoice(respuestasJugador);

        Resultado resultado = preguntaMultipleChoice.responder(respuestaMultipleChoice,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(-1, puntosRepresentados.representar());
    }
}
