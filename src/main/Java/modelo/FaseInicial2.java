package modelo;

public class FaseInicial2 extends FaseInicial{

	public FaseInicial2(Juego juego){
		super(juego);
	}
	
	@Override
	public void terminarTurno() {
		if(juego.turnoActual.numeroDePiezas() == 0 ){
			System.out.println("Al menos se necesita 1 unidad para terminar la fase inicial");
			return;
		}
		
		juego.turnoActual = juego.jugador1;
		juego.tablero.actualizarUnidadesDeJugadores(juego.jugador1.unidades(), juego.jugador2.unidades());
		
		juego.cambiarEstado(juego.enTurno);
	}

	
}
