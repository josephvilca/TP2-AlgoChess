package modelo;
import static org.junit.Assert.*;
import org.junit.Test;

public class JugadorTest {

	@Test
    public void jugadorNoPuedeTomarMasEntidadesDeLosQuePuedeCommprar(){
 
    	Jugador jugador = new Jugador(20);
    	Tienda tienda = new Tienda ();
    	
    	tienda.venderUnidad(jugador, 3);
    	tienda.venderUnidad(jugador, 3);
    	tienda.venderUnidad(jugador, 3);
    	tienda.venderUnidad(jugador, 3);
    	tienda.venderUnidad(jugador, 2);
    	
    	
    	
    	assertEquals(jugador.numeroDePiezas(), 4);

    }

}