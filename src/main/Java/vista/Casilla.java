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
	
	public void stackear(String ruta){
		ImageView imagen = new ImageView(new Image((ruta), 25, 0, true, true));
		getChildren().add(imagen);
	}
	
	public void quitarUltimo(){
		getChildren().remove(getChildren().size()-1);
	}
	
	public int x(){
		return this.x;
	}
	
	public int y(){
		return this.y;
	}
}