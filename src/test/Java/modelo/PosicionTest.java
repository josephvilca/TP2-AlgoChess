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
	
	
}
