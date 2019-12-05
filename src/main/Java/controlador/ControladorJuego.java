  
package controlador;

import javafx.scene.layout.*;

import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import modelo.*;
import vista.Casilla;
import vista.JuegoVista;
import javafx.scene.media.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorJuego {

    private Juego juego;
    private JuegoVista juegoVista;



    public ControladorJuego(JuegoVista juegoVista, Juego  juego) {

        this.juego = juego;
        this.juegoVista = juegoVista;
        juegoVista.setControlador(this);

    }
    

    public void actualizarVista() {
    	HashMap<Posicion, UnidadDeJuego> casillas =  juego.casillas();
    	
    	GridPane mapa = juegoVista.mapa();
    	mapa.getChildren().clear();
    	
        for(int i= 0; i <= 19 ; i++){
        	
        	for(int j= 0; j <= 19 ; j++){
        		Casilla casilla = new Casilla(30, i, j);
        		casilla.setOnMouseClicked(e -> {
        			System.out.println("casillero clickeado");
       				if(e.getClickCount() == 2 && juegoVista.tienda.indiceSeleccionado() != -1){
        				posicionarPieza(juegoVista.tienda.indiceSeleccionado(), casilla);
        				this.juegoVista.tienda.limpiarSeleccion();
        				System.out.println("doble click");

        			}else if( e.getButton() == MouseButton.SECONDARY ){
        				this.juegoVista.casillaSeleccionada2 = casilla;
        				this.seleccionar2(casilla.x(), casilla.y());
        			}else if( e.getButton() == MouseButton.PRIMARY){
        				this.juegoVista.casillaSeleccionada= casilla;
        				this.seleccionar1(casilla.x(), casilla.y());
        			}
       				

        		});
        		
        		UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(i, j);
        		if(unidad != null) casilla.stackear(unidad.getClass().getSimpleName()+".png");
        		mapa.add(casilla, i, j);
        		
            }
        	
        }
    }
    
    public void accionar(Casilla casilla, Casilla casillaObjetivo){
    	if(casilla == null || casillaObjetivo == null) return;
    	juego.accionar(casillaObjetivo.x(), casillaObjetivo.y());
    	
    	this.actualizarObjetivo(casillaObjetivo);	
    }
    
    public void mover(Casilla casilla, Casilla casillaObjetivo){
    	
    	if(casilla == null || casillaObjetivo == null) return;
    	juego.moverPiezaSeleccionada(casillaObjetivo.x(), casillaObjetivo.y());
    	/*
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(casilla.x(), casilla.y());	
    	casilla.quitarUltimo();
    	if(unidad == null) casilla.stackear("casilla.png");
    	else casilla.stackear(unidad.getClass().getSimpleName()+".png");
    	
    	casillaObjetivo.quitarUltimo();
    	UnidadDeJuego unidad2 = juego.obtenerUnidadDelTablero(casillaObjetivo.x(), casillaObjetivo.y());
    	if(unidad2 == null) casillaObjetivo.stackear("casilla.png");
    	else casillaObjetivo.stackear(unidad2.getClass().getSimpleName()+".png");
    	*/
    	
    	this.actualizarVista();
    }
    
    public void actualizarObjetivo(Casilla casillaObjetivo){
    	
    	casillaObjetivo.quitarUltimo();
    	UnidadDeJuego unidad2 = juego.obtenerUnidadDelTablero(casillaObjetivo.x(), casillaObjetivo.y());
    	if(unidad2 == null) casillaObjetivo.stackear("casilla.png");
    	else casillaObjetivo.stackear(unidad2.getClass().getSimpleName()+".png");
    	
    }

    public void seleccionar1(int x, int y){
    	juego.seleccionarDelTablero(x, y);
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(x, y);
    	if(unidad == null) return;
    	
    	juegoVista.itemSeleccionado1.quitarUltimo();
    	VBox v = new VBox();
    	
    	ImageView imagen = new ImageView(new Image((unidad.getClass().getSimpleName()+".png"), 60, 0, true, true));
    	Label hp = new Label(Integer.toString(unidad.vida()) ); 
    	v.setAlignment(Pos.CENTER);
    	v.getChildren().addAll(imagen, hp);
    	juegoVista.itemSeleccionado1.stackear(v);
    }

    public void seleccionar2(int x, int y){
    	
    	VBox v = new VBox();
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(x, y);
    	if(unidad == null) return;
    	juegoVista.itemSeleccionado2.quitarUltimo();
    	
    	ImageView imagen = new ImageView(new Image((unidad.getClass().getSimpleName()+".png"), 60, 0, true, true));
    	Label hp = new Label(Integer.toString(unidad.vida()) ); 
    	v.setAlignment(Pos.CENTER);
    	v.getChildren().addAll(imagen, hp);
    	juegoVista.itemSeleccionado2.stackear(v);
    }

    public void terminar(){
    	juego.concluirTurno();
    	this.actualizarNombreTurnoActual();
    	juegoVista.tienda.setVisible(false);
    }
    
    public void posicionarPieza(int indice, Casilla casilla ){
    	juegoVista.tienda.setVisible(false);
    	juego.comprarUnidad(indice, casilla.x(), casilla.y());
    	/*
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(casilla.x(), casilla.y());
    	if(unidad == null) {
    		juegoVista.tienda.reiniciarInidice();
    		return;
    	}
    	String ruta = unidad.getClass().getSimpleName()+".png";
    	System.out.println(ruta);
    	System.out.println(casilla.getChildren().size());
 
    	casilla.quitarUltimo();
    	casilla.stackear(ruta);
    	*/
    	this.actualizarVista();
    	juegoVista.tienda.reiniciarInidice();
    	actualizarNombreTurnoActual();
    	
    }
    
    public void abrirShop(){
    	juegoVista.tienda.setVisible(true);
    }
    
    public void seleccionarNombreJugador2(String nombre){
    	Label label = new Label(nombre);
    	this.juegoVista.setearNombreJugador(label);
    	this.juego.setNombreJugador2(nombre);
    	
    }
    
    public void seleccionarNombreJugador1(String nombre){
    	Label label = new Label(nombre);
    	this.juegoVista.setearNombreJugador(label);
    	this.juego.setNombreJugador1(nombre);
    	
    }
    
    public void actualizarNombreTurnoActual(){
    	Label label = new Label("EL TURNO ES DE : "+ juego.getNombreJugadorTurnoActual());
    	//label.setMinSize(60.0, 60.0);
    	Label labelCoins = new Label("Monedas : "+ juego.monedasDelJugador());
    	label.setStyle("-fx-font: 24 arial");
    	labelCoins.setStyle("-fx-font: 24 arial");
    	this.juegoVista.setearTurnoActual(label, labelCoins);
    }
    
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }


}
