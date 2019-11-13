package test.modelo;

import org.junit.Assert;
import org.junit.Test;
import modelo.*;

public class UnidadesTest {


    @Test
    public void jineteSeMueveALaDerecha(){
 
    	UnidadDeJuego jinete = new Jinete();
    	
    	Tablero tablero = new Tablero();
    	
    	Posicion posicionInicial = new Posicion(5,2);
    	Posicion posicionDerecha = new Posicion(6,2);
    	
    	tablero.posicionarUnidad(posicionInicial, jinete);
    	tablero.moverUnidadDerecha(posicionInicial);
    	
    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionDerecha);
    	
    	
    	Assert.assertEquals(resultado, jinete);

    }
}
