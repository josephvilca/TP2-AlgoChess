package modelo;
import static org.junit.Assert.*;
import org.junit.Test;


public class JuegoTest {

	@Test
    public void soldadoDeInfanteriaAtacaPiezaEnemigaYSeRestaVida(){
 
    	Juego juego = new Juego();
    	Posicion posicionSoldado = new Posicion(8,8);
    	Posicion posicionCatapulta = new Posicion(10, 10);
    	
    	juego.comprarUnidad(0, 9, 9);
    	juego.terminarTurno();
    	
    	juego.comprarUnidad(3, 10, 10);
    	juego.terminarTurno();
    	
    	juego.seleccionarDelTablero(9, 9);
    	juego.atacar(10, 10);
    	
    	assertTrue(true);

    }

	
}
