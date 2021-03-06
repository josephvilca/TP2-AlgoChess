package modelo;

public class TurnoTerminado implements EstadoDeTurno{

	Juego juego;
	
	public TurnoTerminado(Juego juego){
		this.juego = juego;
	}
	
	@Override
	public void seleccionarDelTablero(int x, int y) {
		System.out.println("El turno se ha terminado, no se puede seleccionar ");
	}

	@Override
	public void posicionarUnidad(int x, int y) {
		System.out.println("El turno se ha terminado, no se puede posicionar");
	}

	@Override
	public void terminarTurno() {

		juego.terminarTurno();
		if(juego.finDelJuego()) {
			juego.cambiarEstado(juego.finDelJuego);
		}else
			juego.cambiarEstado(juego.enTurno);
	}

	@Override
	public void accionar(int x, int y) {
		System.out.println("No se pueden realizar mas acciones por este turno");
	}

	@Override
	public void moverPiezaSeleccionada(int x, int y) {
		System.out.println("El turno se hah terminado, no se pueden mover mas objetos");
	}

	@Override
	public void comprarUnidad(int indice, int x, int y) {
		System.out.println("No se pueden realizar mas acciones por este turno");
	}

}
