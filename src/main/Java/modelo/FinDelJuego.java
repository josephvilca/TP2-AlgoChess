package modelo;

public class FinDelJuego implements EstadoDeTurno{
	
	
	public FinDelJuego(Juego juego){
		
	}
	
	@Override
	public void seleccionarDelTablero(int x, int y) {
		System.out.println("FIN DEL JUEGOOOOO ");
	}

	@Override
	public void posicionarUnidad(int x, int y) {
		System.out.println("FIN DEL JUEGOOOOO ");
	}

	@Override
	public void terminarTurno() {
		System.out.println("FIN DEL JUEGOOOOO ");
	}

	@Override
	public void accionar(int x, int y) {
		System.out.println("FIN DEL JUEGOOOOO ");		
	}

	@Override
	public void moverPiezaSeleccionada(int x, int y) {
		System.out.println("FIN DEL JUEGOOOOO ");
	}

	@Override
	public void comprarUnidad(int indice, int x, int y) {
		System.out.println("FIN DEL JUEGOOOOO ");
	}
	
}
