package modelo;
import static org.junit.Assert.*;
import org.junit.Test;


public class PosicionTest {

	@Test
    public void posicionDerechaDevuelveDerecha(){
 
    	Posicion posicion = new Posicion(3,5);
    	Posicion posicionDerecha = new Posicion(4,5);
    	
    	
    	assertTrue(posicionDerecha.equals(posicion.getPosicionDerecha()));

    }

	@Test
    public void posicionIzquierdaDevuelveIzquierda(){
 
    	Posicion posicion = new Posicion(3,5);
    	Posicion posicionIzquierda= new Posicion(2,5);
    	
    	
    	assertTrue(posicionIzquierda.equals(posicion.getPosicionIzquierda()));

    }
	
	@Test
    public void posicionAbajoDevuelveAbajo(){
 
    	Posicion posicion = new Posicion(3,5);
    	Posicion posicionAbajo = new Posicion(3,4);
    	
    	
    	assertTrue(posicionAbajo.equals(posicion.getPosicionAbajo()));

    }
	
	@Test
    public void posicionArribaDevuelveArriba(){
 
    	Posicion posicion = new Posicion(3,5);
    	Posicion posicionArriba= new Posicion(3,6);
    	
    	
    	assertTrue(posicionArriba.equals(posicion.getPosicionArriba()));

    }
	
	@Test
    public void distanciaDe55a66es1Cuadro(){
 
    	Posicion posicion = new Posicion(5,5);
    	Posicion posicionDiagonalMaxima= new Posicion(6,6);
    	
    	
    	assertTrue(posicionDiagonalMaxima.aDistancia1(posicion));

    }
	
	@Test
    public void distanciaDe55a56es1Cuadro(){
 
    	Posicion posicion = new Posicion(5,5);
    	Posicion posicionDiagonalMaxima= new Posicion(5,6);
    	
    	
    	assertTrue(posicionDiagonalMaxima.aDistancia1(posicion));

    }

	@Test
    public void distanciaDe55a45es1Cuadro(){
 
    	Posicion posicion = new Posicion(5,5);
    	Posicion posicionDiagonalMaxima= new Posicion(4,5);
    	
    	
    	assertTrue(posicionDiagonalMaxima.aDistancia1(posicion));

    }
	
	@Test
    public void distanciaDe55a46es1Cuadro(){
 
    	Posicion posicion = new Posicion(5,5);
    	Posicion posicionDiagonalMaxima= new Posicion(4,6);
    	
    	
    	assertTrue(posicionDiagonalMaxima.aDistancia1(posicion));

    }
	
	
	@Test
    public void distanciaDe55a77es2Cuadros(){
 
    	Posicion posicion = new Posicion(5,5);
    	Posicion posicionDiagonalMaxima= new Posicion(7,7);
    	
    	
    	assertTrue(posicionDiagonalMaxima.aDistancia2(posicion));

    }
	
	@Test
    public void distanciaDe55a77Noes1Cuadro(){
 
    	Posicion posicion = new Posicion(5,5);
    	Posicion posicionDiagonalMaxima= new Posicion(7,7);
    	
    	
    	assertFalse(posicionDiagonalMaxima.aDistancia1(posicion));

    }		
	
}
