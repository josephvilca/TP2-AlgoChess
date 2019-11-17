package modelo;

public class Juego {
	
	Tablero tablero;
	Jugador jugador1, jugador2;
	UnidadDeJuego unidadSeleccionada;

	public Juego() {
		this.tablero = new Tablero();
		jugador1 = new Jugador(20);
		jugador2 = new Jugador(20);
		
	}
	
	public void seleccionar(Posicion posicionSeleccionada) {
		unidadSeleccionada = this.tablero.obtenerUnidad(posicionSeleccionada);
		
	}
	
	public void  accionarSobreUnidad(Posicion posicionUnidad) {
		UnidadDeJuego unidadObjetivo = this.tablero.obtenerUnidad(posicionUnidad);
		
	
	}
	
}
