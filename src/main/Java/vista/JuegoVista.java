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
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class JuegoVista {

    private ControladorJuego controlador;
    private BorderPane main;
    public Casilla itemSeleccionado1, itemSeleccionado2, casillaSeleccionada, casillaSeleccionada2;
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
        contenedorNombres.setAlignment(Pos.CENTER);
        casillaSeleccionada = null;
        
        for(int i= 0; i <= 19 ; i++){
        	
        	for(int j= 0; j <= 19 ; j++){
        		Casilla casilla = new Casilla(30, i, j);
        		casilla.setOnMouseClicked(e -> {
        			if(e.getClickCount() == 2 && tienda.indiceSeleccionado() != -1){
        				this.controlador.posicionarPieza(tienda.indiceSeleccionado(), casilla);
        				tienda.limpiarSeleccion();
        				System.out.println("doble click");

        			}else if( e.getButton() == MouseButton.SECONDARY ){
        				this.casillaSeleccionada2 = casilla;
        				this.controlador.seleccionar2(casilla.x, casilla.y);
        			}else if( e.getButton() == MouseButton.PRIMARY){
        				this.casillaSeleccionada= casilla;
        				this.controlador.seleccionar1(casilla.x, casilla.y);
        			}
       				

        		});
        		
        		mapa.add(casilla, i, j);
        		
            }
        	
        }
   
        mapa.setAlignment(Pos.CENTER);
        main.setCenter(mapa);
        
        VBox contenedorDerecha = new VBox();
        contenedorDerecha.setAlignment(Pos.CENTER_LEFT);
        
        accionarBoton = new Boton("ACCIONAR");
        accionarBoton.setOnAction(e -> {
        	this.controlador.accionar(casillaSeleccionada, casillaSeleccionada2);
        	limpiarSeleccionadores();
		});
        
        moverBoton = new Boton("MOVER");
        moverBoton.setOnAction(e -> {
        	this.controlador.mover(casillaSeleccionada, casillaSeleccionada2);
        	limpiarSeleccionadores();
		});
        
        comprarBoton = new Boton("COMPRAR");
        comprarBoton.setOnAction(e -> {
        	this.controlador.abrirShop();
		});
        
        terminarBoton = new Boton("TERMINAR TURNO");
        terminarBoton.setOnAction(e -> {
        	this.controlador.terminar();
        	limpiarSeleccionadores();
		});
        
        tienda = new Tienda();
        
        tienda.setVisible(false);
        
        HBox contH = new HBox();
        
        itemSeleccionado1 = new Casilla(60);
        itemSeleccionado2 = new Casilla(60);
        
        itemSeleccionado1.getChildren().add(new Casilla(60));
        itemSeleccionado2.getChildren().add(new Casilla(60));
        
        contH.getChildren().addAll(itemSeleccionado1, itemSeleccionado2);
        
        contenedorDerecha.getChildren().addAll(contH, accionarBoton, moverBoton, comprarBoton, terminarBoton, tienda);
                
        contenedorDerecha.setSpacing(8.0);
        this.main.setRight(contenedorDerecha);
        this.main.setLeft(this.contenedorNombres);
        
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
	   v.setSpacing(8.0);
	   v.getChildren().addAll(nombreDeJugador, nombreMonedas);
	   this.main.setTop(v);

   }
   
   public GridPane mapa(){
	   return mapa;
   }
   
    public ControladorJuego getControlador(){
    	return this.controlador;
    }
    
    public void limpiarSeleccionadores(){
    	itemSeleccionado1.quitarUltimo();
        itemSeleccionado2.quitarUltimo();
        
    	itemSeleccionado1.getChildren().add(new Casilla(60));
        itemSeleccionado2.getChildren().add(new Casilla(60));
        
        casillaSeleccionada = null;
        casillaSeleccionada2 = null;
    }
 }
