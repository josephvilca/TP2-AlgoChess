package test.modelo;

public class PosicionTest {

	@Test
    public void posicionDerechaDevuelveDerecha(){
 
    	Posicion posicion = new Posicion(3,5);
    	Posicion posicionDerecha = new Posicion(4,5);
    	
    	
    	Assert.assertTrue(posicionDerecha.equals(posicion.getPosicionDerecha));

    }

	@Test
    public void posicionIzquierdaDevuelveIzquierda(){
 
    	Posicion posicion = new Posicion(3,5);
    	Posicion posicionIzquierda= new Posicion(2,5);
    	
    	
    	Assert.assertTrue(posicionIzquierda.equals(posicion.getPosicionIzquierda));

    }
	
	@Test
    public void posicionAbajoDevuelveAbajo(){
 
    	Posicion posicion = new Posicion(3,5);
    	Posicion posicionAbajo = new Posicion(3,4);
    	
    	
    	Assert.assertTrue(posicionAbajo.equals(posicion.getPosicionAbajo));

    }
	
	@Test
    public void posicionArribaDevuelveArriba(){
 
    	Posicion posicion = new Posicion(3,5);
    	Posicion posicionArriba= new Posicion(3,6);
    	
    	
    	Assert.assertTrue(posicionArriba.equals(posicion.getPosicionArriba));

    }
	
	
}
