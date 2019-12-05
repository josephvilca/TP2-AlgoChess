package vista;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Tienda extends VBox{
	
	RadioButton soldado, jinete, curandero, catapulta;
	ToggleGroup grupo;
	int indiceElegido;
	
	public Tienda(){
		soldado = new RadioButton("Soldado De Infaneria");
		jinete= new RadioButton("Jinete");
		curandero= new RadioButton("Curandero");
		catapulta = new RadioButton("Catapulta");
		
		//soldado.setOnAction(value);
		grupo = new ToggleGroup();
		
		soldado.setToggleGroup(grupo);
		jinete.setToggleGroup(grupo);
		curandero.setToggleGroup(grupo);
		catapulta.setToggleGroup(grupo);
		
		indiceElegido = -1;
		
		soldado.setOnAction(e -> {
        	indiceElegido = 0;
		});
		
		jinete.setOnAction(e -> {
        	indiceElegido = 1;
		});
		
		curandero.setOnAction(e -> {
        	indiceElegido = 2;
		});
		
		catapulta.setOnAction(e -> {
        	indiceElegido = 3;
		});
		
		
		setSpacing(3.0);
		getChildren().addAll(soldado, jinete, curandero, catapulta);
	}
	
	public int indiceSeleccionado(){
		return indiceElegido;
	}
	
	public void reiniciarInidice(){
		indiceElegido = -1;
	}
}
