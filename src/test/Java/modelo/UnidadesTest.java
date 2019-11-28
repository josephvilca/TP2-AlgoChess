package modelo;

import static org.junit.Assert.*;
import org.junit.Test;

public class UnidadesTest {


    @Test
    public void jineteSeMueveALaDerecha(){

    	UnidadDeJuego jinete = new Jinete();
    	
    	Tablero tablero = new Tablero();
    	
    	Posicion posicionInicial = new Posicion(5,2);
    	Posicion posicionDerecha = new Posicion(6,2);


    	tablero.posicionarUnidad(posicionInicial, jinete);
    	//tablero.moverUnidad(posicionInicial, posicionDerecha);
    	tablero.posicionarUnidad(posicionDerecha, jinete);
    	
    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionDerecha);
    	
    	
    	assertEquals(resultado, jinete);

    }
    
    @Test
    public void jineteSeMueveALaIzquierda(){
 
    	UnidadDeJuego jinete = new Jinete();
    	
    	Tablero tablero = new Tablero();
    	
    	Posicion posicionInicial = new Posicion(5,2);
    	Posicion posicionIzquierda = new Posicion(4,2);
    	
    	tablero.posicionarUnidad(posicionInicial, jinete);
    	tablero.posicionarUnidad(posicionIzquierda, jinete);
    	
    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionIzquierda);
    	
    	
    	assertEquals(resultado, jinete);

    }

    @Test
    public void jineteSeMueveAbajo(){
 
    	UnidadDeJuego jinete = new Jinete();
    	
    	Tablero tablero = new Tablero();
    	
    	Posicion posicionInicial = new Posicion(5,2);
    	Posicion posicionAbajo = new Posicion(5,1);
    	
    	tablero.posicionarUnidad(posicionInicial, jinete);
    	tablero.posicionarUnidad(posicionAbajo, jinete);

    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionAbajo);
    	
    	
    	assertEquals(resultado, jinete);

    }


    @Test
    public void jineteSeMueveArriba(){
 
    	UnidadDeJuego jinete = new Jinete();
    	
    	Tablero tablero = new Tablero();
    	
    	Posicion posicionInicial = new Posicion(5,2);
    	Posicion posicionArriba= new Posicion(5,3);
    	
    	tablero.posicionarUnidad(posicionInicial, jinete);
    	tablero.posicionarUnidad(posicionArriba, jinete);    
    	
    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionArriba);
    	
    	
    	assertEquals(resultado, jinete);

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
    	
    	tablero.posicionarUnidad(posicionAbajo, jinete);
    	
    	UnidadDeJuego resultado = tablero.obtenerUnidad(posicionInicialJinete);
    	
    	
    	assertEquals(resultado, jinete);

    }


}
