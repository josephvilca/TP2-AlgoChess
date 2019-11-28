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


public class JuegoVista {

    private ControladorJuego controlador;
    private BorderPane main;
    private Casilla itemSeleccionado;
    private VBox contenedorNombres;
    
    public JuegoVista(ControladorDeEscena controladorDeEscena) {
        main = new BorderPane();
        main.setId("juego-escena");

        
        this.main.setStyle("-fx-background-image: url('fondoJuego.jpg')");
        
        this.contenedorNombres = new VBox();
        this.contenedorNombres.setSpacing(500.0);
        //this.contenedorNombres.set
        
        VBox contenedorVertical = new VBox();
        contenedorVertical.setAlignment(Pos.CENTER_RIGHT );
        
        for(int i= 19; i >= 0 ; i--){
        	HBox contenedorHorizontal = new HBox(); 
        	
        	for(int j= 0; j <= 19 ; j++){
        		Casilla casilla = new Casilla(30, j, i);
        		contenedorHorizontal.getChildren().add(casilla);
            }
        	
        	contenedorVertical.getChildren().add(contenedorHorizontal);       	
        	
        }
        
        this.main.setCenter(contenedorVertical);
        
        VBox contenedorDerecha = new VBox();
        contenedorDerecha.setAlignment(Pos.CENTER_LEFT);
        
        this.itemSeleccionado = new Casilla(60);
        contenedorDerecha.getChildren().add(this.itemSeleccionado);
        
        this.main.setRight(contenedorDerecha);
        this.main.setLeft(this.contenedorNombres);
        
        
/*
    public void setControlador(ControladorDelJuego controlador) {
        this.controlador = controlador;
    }
*/
    }
    
    public Pane pane(){
    	return this.main;
    }
    
    public void setControlador(ControladorJuego controlador){
    	this.controlador = controlador;
    }
    
    public void setearNombreJugador(Label nombre){
    	this.contenedorNombres.getChildren().add(nombre);
    }
    
   public void setearTurnoActual(Label nombreDeJugador){
	   HBox v = new HBox();
	   v.setAlignment(Pos.CENTER);
	   v.getChildren().add(nombreDeJugador);
	   this.main.setTop(v);

   }
    
    public ControladorJuego getControlador(){
    	return this.controlador;
    }
 }
