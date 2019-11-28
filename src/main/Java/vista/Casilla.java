package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Casilla extends StackPane{

	int x, y;
	
	public Casilla(int tam){
		
        setId("casilla");
        
        ImageView imageView = new ImageView(new Image(("casilla.png"), tam, 0, true, true));
        getChildren().add(imageView);    
	}
	
	public Casilla(int tam, int x, int y){

		this.x = x;
		this.y = y;
		
        setId("casilla");
        
        ImageView imageView = new ImageView(new Image(("casilla.png"), tam, 0, true, true));
        getChildren().add(imageView);   
        Label coordenadas = new Label(Integer.toString(x)+"," + Integer.toString(y) );
        getChildren().add(coordenadas);
	}
}