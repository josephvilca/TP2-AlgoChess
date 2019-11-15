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
    
    @Test
    public void jineteSeMueveALaIzquierda(){
 
    	UnidadDeJuego jinete = new Jinete();
    	
    	Tablero tablero = new Tablero();
    	
    	Posicion posicionInicial = new Posicion(5,2);
    	Posicion posicionIzquierda = new Posicion(4,2);
    	
    	tablero.posicionarUnidad(posicionInicial, jinete);
    	tablero.moverUnidadIzquierda(posicionInicial);
    	
    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionIzquierda);
    	
    	
    	Assert.assertEquals(resultado, jinete);

    }

    @Test
    public void jineteSeMueveAbajo(){
 
    	UnidadDeJuego jinete = new Jinete();
    	
    	Tablero tablero = new Tablero();
    	
    	Posicion posicionInicial = new Posicion(5,2);
    	Posicion posicionAbajo = new Posicion(5,1);
    	
    	tablero.posicionarUnidad(posicionInicial, jinete);
    	tablero.moverUnidadAbajo(posicionInicial);
    	
    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionAbajo);
    	
    	
    	Assert.assertEquals(resultado, jinete);

    }


    @Test
    public void jineteSeMueveArriba(){
 
    	UnidadDeJuego jinete = new Jinete();
    	
    	Tablero tablero = new Tablero();
    	
    	Posicion posicionInicial = new Posicion(5,2);
    	Posicion posicionArriba= new Posicion(5,3);
    	
    	tablero.posicionarUnidad(posicionInicial, jinete);
    	tablero.moverUnidadArriba(posicionInicial);
    	
    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionArriba);
    	
    	
    	Assert.assertEquals(resultado, jinete);

    }
    
    
    @Test
    public void jineteSeMueveAUnaPosicionOcupadaYSeQuedaEnelMismoLugar(){
 
    	UnidadDeJuego jinete = new Jinete();
    	UnidadDeJuego curandero= new Curandero();
    	
    	
    	Tablero tablero = new Tablero();
    	
    	Posicion posicionInicialJinete = new Posicion(5,2);
    	Posicion posicionAbajo = new Posicion(5,1);
    	
    	tablero.posicionarUnidad(posicionInicialJinete, jinete);
    	tablero.posicionarUnidad(posicionAbajo, curandero);
    	
    	tablero.moverUnidadAbajo(posicionInicialJinete);
    	
    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionInicialJinete);
    	
    	
    	Assert.assertEquals(resultado, jinete);

    }


}
