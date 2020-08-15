package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

public class BotonSpinnerGrupo extends HBox {

    private final static String AMARILLO = "FBD87F";
    private final OpcionSimple opcionSpinner;
    private final Spinner<String> spinner;

    public BotonSpinnerGrupo(ArrayList<String> nombresGrupos, OpcionSimple opcion, ControladorEnviarGroupChoice controlador) {


        ObservableList<String> nombresGruposPosibles = FXCollections.observableArrayList(); //estos strings deberian recibirse por parametro.
        nombresGruposPosibles.addAll(nombresGrupos);

        spinner = new Spinner<>();
        opcionSpinner = opcion;

        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(nombresGruposPosibles);
        valueFactory.setValue(nombresGruposPosibles.get(0)); //valor por defecto
        spinner.setValueFactory(valueFactory);
        spinner.setMaxWidth(350);
        spinner.setMaxHeight(50);
        spinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);


        Background unFondito = new Background(new BackgroundFill(Color.web(AMARILLO), new CornerRadii(0), new Insets(1)));
        Label label = new Label(opcion.obtenerTexto());
        label.setBackground(unFondito);
        label.setFont(Font.font("montserrat", 25));
        label.setTextFill(Color.BLACK);

        super.setAlignment(Pos.CENTER);
        super.setSpacing(2);
        super.getChildren().addAll(spinner, label);
    }
    public String getGrupoOpcion(){
        return spinner.getValue();
    }
    public OpcionSimple getOpcionSpinner() { return opcionSpinner;}
}
