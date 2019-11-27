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



public class JuegoVista {

    private GridPane mapa;
//    private ControladorDelJuego controlador;
    private BorderPane main;


    public JuegoVista(ControladorDeEscena controladorDeEscena) {
        main = new BorderPane();
        main.setId("juego-escena");

        this.mapa = new GridPane();
        mapa.setAlignment(Pos.CENTER);

        this.main.setStyle("-fx-background-image: url('fondoJuego.jpg')");

/*
    public void setControlador(ControladorDelJuego controlador) {
        this.controlador = controlador;
    }
*/
    }
    
    public Pane pane(){
    	return this.main;
    }
 }
