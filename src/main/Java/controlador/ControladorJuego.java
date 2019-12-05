  
package controlador;

import javafx.scene.layout.*;

import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import modelo.*;
import vista.Casilla;
import vista.JuegoVista;
import javafx.scene.media.*;
import javafx.scene.control.*;

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
    	for(UnidadDeJuego unidad : casillas.values()){
    	//	mapa.getChildren()
    	}
    }
    
    public void mover(){
    	
    	//juego.moverPiezaSeleccionada(x, y);
   
    }

    public void seleccionar(int x, int y){
    	juego.seleccionarDelTablero(x, y);
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(x, y);
    	juegoVista.itemSeleccionado.stackear(unidad.getClass().getName()+".png");
    }

    public void terminar(){
    	
    }
    
    public void posicionarPieza(int indice, Casilla casilla ){
    	juego.comprarUnidad(indice, casilla.x(), casilla.y());
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(casilla.x(), casilla.y());
    	if(unidad == null) return;
    	String ruta = unidad.getClass().getSimpleName()+".png";
    	System.out.println(ruta);
    	System.out.println(casilla.getChildren().size());
 
    	casilla.quitarUltimo();
    	casilla.stackear(ruta);
    	juegoVista.tienda.setVisible(false);
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
