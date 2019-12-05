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
    public Casilla itemSeleccionado;
    private Boton accionarBoton, moverBoton, comprarBoton, terminarBoton;
    public Tienda tienda;
    private VBox contenedorNombres;
    private GridPane mapa;
    
    
    public JuegoVista(ControladorDeEscena controladorDeEscena) {
        main = new BorderPane();
        main.setId("juego-escena");

        mapa = new GridPane();
        
        this.main.setStyle("-fx-background-image: url('fondoJuego.jpg')");
        
        this.contenedorNombres = new VBox();
        this.contenedorNombres.setSpacing(500.0);
        
        for(int i= 0; i <= 19 ; i++){
        	
        	for(int j= 0; j <= 19 ; j++){
        		Casilla casilla = new Casilla(30, i, j);
        		casilla.setOnMouseClicked(e -> {
        			System.out.println(casilla.x);
        			System.out.println(casilla.y);
        			if(e.getClickCount() == 2 && tienda.indiceSeleccionado() != -1){
        				this.controlador.posicionarPieza(tienda.indiceSeleccionado(), casilla);
        				System.out.println("doble click");

        			}
        		});
        		
        		//casilla.setonr
        		mapa.add(casilla, i, j);
        		
            }
        	
        }
        
        this.main.setCenter(this.mapa);
        
        VBox contenedorDerecha = new VBox();
        contenedorDerecha.setAlignment(Pos.CENTER_LEFT);
        
        accionarBoton = new Boton("ACCIONAR");
        accionarBoton.setOnAction(e -> {
        	//	this.controlador.
		});
        
        moverBoton = new Boton("MOVER");
        moverBoton.setOnAction(e -> {
        	//	this.controlador.
		});
        
        comprarBoton = new Boton("COMPRAR");
        comprarBoton.setOnAction(e -> {
        	this.controlador.abrirShop();
		});
        
        terminarBoton = new Boton("TERMINAR TURNO");
        terminarBoton.setOnAction(e -> {
        	//	this.controlador.
		});
        
        tienda = new Tienda();
        
        tienda.setVisible(false);
        
        itemSeleccionado = new Casilla(60);
        contenedorDerecha.getChildren().add(this.itemSeleccionado);
        contenedorDerecha.getChildren().add(accionarBoton);
        contenedorDerecha.getChildren().add(moverBoton);
        contenedorDerecha.getChildren().add(comprarBoton);
        contenedorDerecha.getChildren().add(terminarBoton);
        contenedorDerecha.getChildren().add(tienda);
                
        contenedorDerecha.setSpacing(8.0);
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
    
   public void setearTurnoActual(Label nombreDeJugador, Label nombreMonedas){
	   HBox v = new HBox();
	   v.setAlignment(Pos.CENTER);
	   v.setSpacing(3.0);
	   v.getChildren().addAll(nombreDeJugador, nombreMonedas);
	   this.main.setTop(v);

   }
   
   public GridPane mapa(){
	   return mapa;
   }
   
    public ControladorJuego getControlador(){
    	return this.controlador;
    }
 }
