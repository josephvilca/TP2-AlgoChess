package modelo;

public class Juego {
	
	Tablero tablero;
	Tienda tienda;
	Jugador jugador1, jugador2;
	UnidadDeJuego unidadSeleccionada;
	private int turno;
	
	// TURNOS IMPARES JUGADOR 1, TURNOS PARES JUGADOR 2
	public Juego() {
		this.turno = 1;
		this.tablero = new Tablero();
		this.jugador1 = new Jugador(20);
		this.jugador2 = new Jugador(20);
		this.tienda = new Tienda();
		
	}
	
	public void seleccionarDelTablero(int x, int y) {
		Posicion posicionSeleccionada = new Posicion(x,y);
		unidadSeleccionada = this.tablero.obtenerUnidad(posicionSeleccionada);
		
	}
	
	public void seleccionarDelJugador(int indice) {
		unidadSeleccionada = this.jugador1.obtenerUnidad(indice);
		
	}
	
	public void  accionarSobreUnidad(Posicion posicionUnidad) {
		UnidadDeJuego unidadObjetivo = this.tablero.obtenerUnidad(posicionUnidad);
		
	
	}
	
	public void posicionarUnidad(int x, int y){
		Posicion posicionSeleccionada = new Posicion(x,y);
		this.tablero.posicionarUnidad(posicionSeleccionada, unidadSeleccionada);
	}

	public void terminarTurno(){
		this.turno++;
	}
	
	public void atacar(int x, int y){
		Posicion pos = new Posicion(x, y);
		UnidadDeJuego victima = this.tablero.obtenerUnidad(pos);
		if(this.turno % 2 == 0){  
			this.unidadSeleccionada.atacarMeele(victima);
		}
		else this.unidadSeleccionada.atacarMeele(victima);			;
	}
	
	public void comprarUnidad(int indice, int x, int y){
		Posicion posicionNueva = new Posicion(x,y);

		if(this.turno % 2 == 0){  
			this.tienda.venderUnidad(jugador2, indice);
			this.tablero.posicionarUnidad(posicionNueva, this.jugador2.obtenerUnidad(indice));
		}
		else{
			this.tienda.venderUnidad(jugador1, indice);
			this.tablero.posicionarUnidad(posicionNueva, this.jugador1.obtenerUnidad(indice));
		}
	}
}
