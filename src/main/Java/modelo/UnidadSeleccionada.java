package modelo;

public class UnidadSeleccionada implements EstadoDeTurno{

	Juego juego;
	
	public UnidadSeleccionada(Juego juego){
		this.juego = juego;
	}
	
	
	@Override
	public void seleccionarDelTablero(int x, int y) {
		Posicion posicionSeleccionada = new Posicion(x,y);
		this.juego.unidadSeleccionada = this.juego.tablero.obtenerUnidad(posicionSeleccionada);
	}

	@Override
	public void posicionarUnidad(int x, int y) {
		System.out.println("solo en la fase inicial");
	}

	@Override
	public void terminarTurno() {
		this.juego.terminarTurno();
	}

	@Override
	public void accionar(int x, int y) {
		Posicion pos = new Posicion(x, y);
		this.juego.tablero.accionar(this.juego.unidadSeleccionada, pos);
		this.juego.cambiarEstado(this.juego.turnoTerminado);
	}

	@Override
	public void moverPiezaSeleccionada(int x, int y) {
		Posicion nuevaPosicion = new Posicion(x, y);

		this.juego.tablero.moverUnidad(this.juego.unidadSeleccionada.getPosicion(), nuevaPosicion);
		this.juego.cambiarEstado(this.juego.turnoTerminado);
	}

	@Override
	public void comprarUnidad(int indice, int x, int y) {
		System.out.println("solo en la fase inicial");
	}
	
}
