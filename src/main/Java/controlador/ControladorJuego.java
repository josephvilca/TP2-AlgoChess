  
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
    	/*Posicion posJugador = juego.getJugador().miPosicion();

        for(int row = 0; row < juego.getMapa().getFilas() ; row++)
        {
            for(int col = 0; col < juego.getMapa().getColumnas(); col++)
            {
                Posicion posicion = new Posicion(row,col);
                Material objeto = juego.getMapa().obtenerObjeto(posicion);
                
                String nombreImagen = "SinMaterial.png";
                if(objeto.getClass() == Madera.class)
                	nombreImagen = "madera.png";
                if(objeto.getClass() == Diamante.class)
                	nombreImagen = "diamante.png";
                if(objeto.getClass() == Metal.class)
                	nombreImagen = "metal.png";
                if(objeto.getClass() == Piedra.class)
                	nombreImagen = "piedra.png";
                
                if(!posJugador.equals(posicion)) juegoVista.agregarElemento(nombreImagen, col, row);
            }
        }
        
        juegoVista.agregarElemento("jugador.png", juego.getJugador().getPosicionFila(), juego.getJugador().getPosicionColumna());
        */
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
    	label.setMinSize(60.0, 60.0);
    	this.juegoVista.setearTurnoActual(label);
    }
    

}
