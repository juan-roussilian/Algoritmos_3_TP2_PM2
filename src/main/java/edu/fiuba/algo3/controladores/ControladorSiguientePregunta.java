package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.GroupChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.MultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import edu.fiuba.algo3.vistas.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.EmptyStackException;

public class ControladorSiguientePregunta implements EventHandler<ActionEvent> {

    private Stage stage;

    public ControladorSiguientePregunta(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Pregunta pregunta = AlgoHoot.getInstance().pedirJugada().obtenerPregunta();
            determinarTipoPregunta(pregunta);
        }catch (EmptyStackException exception){ //Ver mejor forma de arreglar esto
            VistaGanador vistaGanador = new VistaGanador(stage);
            Scene scene = new Scene(vistaGanador,800,600);
            stage.setScene(scene);
        }

    }

    private void determinarTipoPregunta(Pregunta pregunta) {

        // Esto se borra y pasa a ser el llamado a la fabrica


        //StackPane vistaPregunta = FabricaDeVistas.CrearVistaDePregunta(pregunta, stage);
        //Scene scene = new Scene(vistaPregunta,800,600);
        //stage.setScene(scene);

        //Se borra
        if(pregunta instanceof VerdaderoFalso){
            VistaVerdaderoFalso vistaPregunta = new VistaVerdaderoFalso(stage);
            Scene scene = new Scene(vistaPregunta,800,600);
            stage.setScene(scene);
        }
        else if(pregunta instanceof MultipleChoice){
            StackPane vistaPregunta = FabricaDeVistas.CrearVistaDePregunta(pregunta, stage);
            Scene scene = new Scene(vistaPregunta,800,600);
            stage.setScene(scene);
        }
        else if(pregunta instanceof GroupChoice){
            VistaGroupChoice vistaPregunta = new VistaGroupChoice(stage);
            Scene scene = new Scene(vistaPregunta, 800, 600);
            stage.setScene(scene);
        }
        else{
            VistaOrderedChoice vistaPregunta = new VistaOrderedChoice(stage);
            Scene scene = new Scene(vistaPregunta,800,600);
            stage.setScene(scene);
        }

    }
    
}
