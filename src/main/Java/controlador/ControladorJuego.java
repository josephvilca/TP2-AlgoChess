  
package controlador;

import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import modelo.*;
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

    }
    public void mover(){
    	

   
    }

    public void seleccionar(){
    	
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
    	Label label = new Label("EL TURNO ES DE : "+this.juego.getNombreJugadorTurnoActual());
    	//label.setMinSize(60.0, 60.0);
    	label.setStyle("-fx-font: 24 arial");
    	this.juegoVista.setearTurnoActual(label);
    }
    

}
