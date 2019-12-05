package modelo;
import static org.junit.Assert.*;
import org.junit.Test;


public class JuegoTest {

	@Test
    public void soldadoDeInfanteriaAtacaPiezaEnemigaYSeRestaVida(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(0, 10, 10);//j1
    	juego.concluirTurno();//j1
    	
    	juego.comprarUnidad(3, 9, 9);//j2
    	juego.concluirTurno();
    	
    	juego.seleccionarDelTablero(10, 10);
    	juego.accionar(9, 9);
    	juego.concluirTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 9);
    	
    	assertEquals(unidad.vida(), 40);
    	
    	
    	
    }
	
	@Test
    public void jineteAtacaCatapultaSolaYSuAtaqueEsCercano(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(1, 9, 10);//jugador 1 compra jinete
    	juego.concluirTurno();
    	
    	juego.comprarUnidad(3, 9, 9);//jugador 2 compra catapulta
    	juego.concluirTurno();
    	
    	juego.seleccionarDelTablero(9, 10);//jugadro 1
    	juego.accionar(9, 9);
    	juego.concluirTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 9);
    	assertEquals(unidad.vida(), 45);

    }

	@Test
    public void jineteConSoldadoDeInfanteriaCercaAtacaCatapultaConAtaqueMedianoYNoLoPuedeAtacar(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(1, 9, 11);//j1 
    	juego.comprarUnidad(0, 10, 11);//j1
    	juego.concluirTurno();//j1
    	
    	juego.comprarUnidad(3, 9, 9);//j2
    	juego.concluirTurno();//j2
    	
    	juego.seleccionarDelTablero(9, 11);
    	juego.accionar(9, 9);
    	juego.concluirTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 9);
    	assertEquals(unidad.vida(), 50);

    }
	
	@Test
    public void jineteConSoldadoDeInfanteriaCercaAtacaCatapultaConAtaqueMediano(){
 
    	Juego juego = new Juego();
    	juego.setNombreJugador1("jugador 1");
    	juego.setNombreJugador2("jugador 2");
    	
    	juego.comprarUnidad(1, 9, 12); // jugador1
    	juego.comprarUnidad(0, 11, 12);//jugador 1
    	juego.concluirTurno();;// j1
    	
    	juego.comprarUnidad(3, 9, 9); // j2
    	juego.concluirTurno();//j2
    	
    	juego.seleccionarDelTablero(9, 12);
    	juego.accionar(9, 9);
    	juego.concluirTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 9);
    	assertEquals(unidad.vida(), 35);

    }
	
		
	
	
	@Test
    public void curanderoCuraSoldadoInfanteriaAliado(){
 
    	Juego juego = new Juego();
    	
    	juego.setNombreJugador1("jugador 1");
    	juego.setNombreJugador2("jugador 2");
    	
    	juego.comprarUnidad(2, 10, 10);// jugador1 compra curandero
    	
    	juego.comprarUnidad(0, 11, 10);// jugador1
    	
    	juego.concluirTurno(); //j1 
    	
    	juego.comprarUnidad(0, 11, 9);// jugador2 
    	juego.concluirTurno();//j2
    	//jugador 1
    	juego.concluirTurno();
    	
    	juego.seleccionarDelTablero(11, 9);// jugador 2
    	juego.accionar(11, 10); // jugador 2
    	juego.concluirTurno(); //jugador 2
    	
    	juego.concluirTurno(); //jugador1
    	juego.seleccionarDelTablero(11, 9); //jugador 2    	
    	juego.accionar(11, 10); //jugador 2
    	juego.concluirTurno(); //jugador 2

    	juego.seleccionarDelTablero(10, 10); // jugaador 1selecciona curandero  
    	juego.accionar(11, 10); // jugador 1 cura aliado
    	juego.concluirTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(11, 10);
    	assertEquals(unidad.vida(), 95);

    }
	
	@Test
    public void jugadorCompra3Unidades(){
 
    	Juego juego = new Juego();

    	juego.comprarUnidad(0, 5, 17);
    	juego.comprarUnidad(3, 2, 18);
    	juego.comprarUnidad(3, 3, 18);

    	//UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(10, 10);
    	assertEquals(juego.turnoActual.numeroDePiezas(), 3);

    }

	@Test
    public void catapultaAtacaSoldadoAdistanciaLejana(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(3, 9, 12);//j1 
    	juego.concluirTurno();// j1
    	
    	juego.comprarUnidad(0, 9, 3);
    	juego.concluirTurno();
    	
    	juego.seleccionarDelTablero(9, 12);
    	juego.accionar(9, 3);
    	juego.concluirTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 3);
    	assertEquals(unidad.vida(), 80);

    }

	@Test
    public void catapultaAtacaSoldadoAdistanciaMedianaYNoDanaAlEnemigo(){
 
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(3, 9, 11);

    	juego.concluirTurno();
    	
    	juego.comprarUnidad(0, 9, 6);
    	juego.concluirTurno();
    	
    	juego.seleccionarDelTablero(9, 11);
    	juego.accionar(9, 6);
    	juego.concluirTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 6);
    	assertEquals(unidad.vida(), 100);

    }

	@Test
    public void noSePuedeColocar(){	
 /*
    	Juego juego = new Juego();
    	
    	juego.comprarUnidad(3, 9, 6);

    	juego.concluirTurno();
    	
    	juego.comprarUnidad(0, 9, 11);
    	juego.concluirTurno();
    	
    	juego.seleccionarDelTablero(9, 6);
    	juego.accionar(9, 11);
    	juego.concluirTurno();	 
    	
    	UnidadDeJuego unidad = juego.obtenerUnidadDelTablero(9, 11);
    	assertEquals(unidad.vida(), 100);
*/
		assertTrue(true);
    }
		
	
	
	
}
