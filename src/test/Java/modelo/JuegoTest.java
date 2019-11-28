package modelo;
import static org.junit.Assert.*;
import org.junit.Test;


public class JuegoTest {

	@Test
    public void soldadoDeInfanteriaAtacaPiezaEnemigaYSeRestaVida(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(0, 9, 9);
    	juego.terminarTurno();
    	
    	juego.comprarUnidad(3, 10, 10);
    	juego.terminarTurno();
    	
    	juego.seleccionarDelTablero(9, 9);
    	juego.atacar(10, 10);
    	juego.terminarTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(10, 10);
    	
    	assertEquals(unidad.vida(), 40);
    	
    	
    	
    }
	
	@Test
    public void jineteAtacaCatapultaSolaYSuAtaqueEsCercano(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(1, 9, 9);
    	juego.terminarTurno();
    	
    	juego.comprarUnidad(3, 9, 10);
    	juego.terminarTurno();
    	
    	juego.seleccionarDelTablero(9, 9);
    	juego.atacar(9, 10);
    	juego.terminarTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 10);
    	assertEquals(unidad.vida(), 45);

    }

	@Test
    public void jineteConSoldadoDeInfanteriaCercaAtacaCatapultaConAtaqueMedianoYNoLoPuedeAtacar(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(1, 9, 9);
    	juego.comprarUnidad(0, 7, 9);
    	juego.terminarTurno();
    	
    	juego.comprarUnidad(3, 9, 10);
    	juego.terminarTurno();
    	
    	juego.seleccionarDelTablero(9, 9);
    	juego.atacar(9, 10);
    	juego.terminarTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 10);
    	assertEquals(unidad.vida(), 50);

    }
	
	@Test
    public void jineteConSoldadoDeInfanteriaCercaAtacaCatapultaConAtaqueMediano(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(1, 9, 9);
    	juego.comprarUnidad(0, 7, 9);
    	juego.terminarTurno();
    	
    	juego.comprarUnidad(3, 9, 12);
    	juego.terminarTurno();
    	
    	juego.seleccionarDelTablero(9, 9);
    	juego.atacar(9, 12);
    	juego.terminarTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 12);
    	assertEquals(unidad.vida(), 35);

    }
	
		
	
	
	@Test
    public void curanderoCuraSoldadoInfanteriaAliado(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(2, 8, 8);
    	
    	juego.comprarUnidad(0, 9, 9);
    	
    	juego.terminarTurno();
    	
    	juego.comprarUnidad(0, 10, 10);
    	juego.seleccionarDelTablero(10, 10);
    	juego.atacar(9, 9);
    	juego.terminarTurno();
    	
    	juego.seleccionarDelTablero(10, 10);    	
    	juego.atacar(9, 9);
    	//se termina el turno
    	juego.seleccionarDelTablero(8, 8);
    	juego.curar(9, 9);
    	juego.terminarTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 9);
    	assertEquals(unidad.vida(), 95);

    }
	
	@Test
    public void jugadorCompra3Unidades(){
 
    	Juego juego = new Juego();

    	juego.comprarUnidad(0, 9, 9);
    	juego.comprarUnidad(3, 7, 4);
    	juego.comprarUnidad(3, 7, 3);

    	juego.seleccionarDelTablero(9, 9);

    	//UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(10, 10);
    	assertEquals(juego.turnoActual.numeroDePiezas(), 3);

    }

	@Test
    public void catapultaAtacaSoldadoAdistanciaLejana(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(3, 9, 3);

    	juego.terminarTurno();
    	
    	juego.comprarUnidad(0, 9, 12);
    	juego.terminarTurno();
    	
    	juego.seleccionarDelTablero(9, 3);
    	juego.atacar(9, 12);
    	juego.terminarTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 12);
    	assertEquals(unidad.vida(), 80);

    }

	@Test
    public void catapultaAtacaSoldadoAdistanciaMedianaYNoDanaAlEnemigo(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(3, 9, 6);

    	juego.terminarTurno();
    	
    	juego.comprarUnidad(0, 9, 11);
    	juego.terminarTurno();
    	
    	juego.seleccionarDelTablero(9, 6);
    	juego.atacar(9, 11);
    	juego.terminarTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 11);
    	assertEquals(unidad.vida(), 100);

    }

	@Test
    public void noSePuedeColocar(){
 /*
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(3, 9, 6);

    	juego.terminarTurno();
    	
    	juego.comprarUnidad(0, 9, 11);
    	juego.terminarTurno();
    	
    	juego.seleccionarDelTablero(9, 6);
    	juego.atacar(9, 11);
    	juego.terminarTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 11);
    	assertEquals(unidad.vida(), 100);
*/
		assertTrue(true);
    }
		
	
	
	
}
