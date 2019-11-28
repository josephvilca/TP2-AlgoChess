package vista;

import controlador.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class PreJuego {

	private StackPane main;
	
	public PreJuego(ControladorDeEscena controladorDeEscena, JuegoVista juegoVista){

		this.main = new StackPane();
		this.main.setStyle("-fx-background-image: url('fondoJuego.jpg')");
		
		HBox contenedorInput1 = new HBox();
		Label label1 = new Label("NOMBRE DE JUGADOR1 :");
		TextField inputJugador1 = new TextField();
		inputJugador1.setMaxWidth(150.0);
		contenedorInput1.getChildren().addAll(label1, inputJugador1);
		contenedorInput1.setAlignment(Pos.CENTER);
		
		HBox contenedorInput2 = new HBox();
		Label label2 = new Label("NOMBRE DE JUGADOR1 :");
		TextField inputJugador2 = new TextField();
		inputJugador2.setMaxWidth(150.0);
		contenedorInput2.getChildren().addAll(label2, inputJugador2);
		contenedorInput2.setAlignment(Pos.CENTER);
		
		Boton botonEmpezar = new Boton("Empezar");
		botonEmpezar.setAlignment(Pos.CENTER);
		
		VBox contenedorV = new VBox();
		contenedorV.setSpacing(12.0);
		
		contenedorV.setAlignment(Pos.CENTER);
		contenedorV.getChildren().addAll(contenedorInput1, contenedorInput2, botonEmpezar);
	
		botonEmpezar.setOnAction(e -> {
            controladorDeEscena.activate("juegoVista");
            juegoVista.getControlador().seleccionarNombreJugador2(inputJugador2.getText());
            juegoVista.getControlador().seleccionarNombreJugador1(inputJugador1.getText());
            juegoVista.getControlador().actualizarNombreTurnoActual();
		});
		
		this.main.getChildren().add(contenedorV);
	}
	
	
	
	public Pane pane(){
		return this.main;
	}
	
}
