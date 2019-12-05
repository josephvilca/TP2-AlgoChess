package modelo;
import static org.junit.Assert.*;
import org.junit.Test;

public class JugadorTest {

	@Test
    public void jugadorNoPuedeTomarMasEntidadesDeLosQuePuedeCommprar(){
 
    	Jugador jugador = new Jugador(20);
    	jugador.setearTipoDeUnidades(new UJugador1());
    	Tienda tienda = new Tienda ();
    	
    	tienda.venderUnidad(jugador, 3);
    	tienda.venderUnidad(jugador, 3);
    	tienda.venderUnidad(jugador, 3);
    	tienda.venderUnidad(jugador, 3);
    	
    	
    	
    	assertEquals(jugador.numeroDePiezas(), 4);

    }

	@Test
    public void jugadorSeQuedaSinEntidadesPierde(){
 
    	Jugador jugador = new Jugador(20);
    	jugador.setearTipoDeUnidades(new UJugador1());
    	Tienda tienda = new Tienda ();

    	
    	
    	assertTrue(jugador.derrotado());

    }
	
	
}
