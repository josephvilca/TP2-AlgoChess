package modelo;

public class Juego {
	
	Tablero tablero;
	Tienda tienda;
	Jugador jugador1, jugador2;
	Jugador turnoActual;
	UnidadDeJuego unidadSeleccionada;
	private int turno;
	
	
	// TURNOS IMPARES JUGADOR 1, TURNOS PARES JUGADOR 2
	public Juego() {
		this.turno = 1;
		this.tablero = new Tablero();
		this.jugador1 = new Jugador(20);
		this.jugador2 = new Jugador(20);
		this.tienda = new Tienda();
		turnoActual = jugador1;
		
	}
	
	public String getNombreJugadorTurnoActual(){
		return this.turnoActual.getNombre();
	}
	
	public void setNombreJugador1(String nombre){
		this.jugador1.setNombre(nombre);
	}

	public void setNombreJugador2(String nombre){
		this.jugador2.setNombre(nombre);
	}

	public void seleccionarDelTablero(int x, int y) {
		Posicion posicionSeleccionada = new Posicion(x,y);
		this.unidadSeleccionada = this.tablero.obtenerUnidad(posicionSeleccionada);
	}
	
	public UnidadDeJuego obtenerUnidadDelTablero(int x, int y){
		Posicion posicionUnidad= new Posicion(x,y);
		return this.tablero.obtenerUnidad(posicionUnidad);	
	}
	
	
	public void posicionarUnidad(int x, int y){
		Posicion posicionSeleccionada = new Posicion(x,y);
		this.tablero.posicionarUnidad(posicionSeleccionada, unidadSeleccionada);
	}

	public void terminarTurno(){
		this.turno++;
		if(this.turno % 2 == 0 ) {
			this.turnoActual = this.jugador2;
			this.tablero.actualizarUnidadesDeJugadores(this.jugador2.unidades, this.jugador1.unidades);
		}else{
			this.turnoActual = this.jugador1;
			this.tablero.actualizarUnidadesDeJugadores(this.jugador1.unidades, this.jugador2.unidades);
			
		}
		
		
	}
	
	public void atacar(int x, int y){
		Posicion pos = new Posicion(x, y);
		//this.tablero.atacar(this.unidadSeleccionada, pos);
		this.tablero.accionar(this.unidadSeleccionada, pos);
		this.terminarTurno();
	}
	
	public void curar(int x, int y){
		Posicion pos = new Posicion(x, y);
		//this.tablero.curar(this.unidadSeleccionada, pos);
		this.tablero.accionar(this.unidadSeleccionada, pos);
		this.terminarTurno();
	}
	
	
	public void moverPiezaSeleccionada(int opcion){
		if(this.unidadSeleccionada == null) return;
		switch (opcion){
			case 0:this.tablero.moverUnidadAdelante(this.unidadSeleccionada.posicion);
			case 1:this.tablero.moverUnidadAtras(this.unidadSeleccionada.posicion);
			case 2:this.tablero.moverUnidadDerecha(this.unidadSeleccionada.posicion);
			case 3:this.tablero.moverUnidadIzquierda(this.unidadSeleccionada.posicion);
		}
	}
	
	
	
	public void comprarUnidad(int indice, int x, int y){
		Posicion posicionNueva = new Posicion(x,y);

		this.tienda.venderUnidad(this.turnoActual, indice);
		this.tablero.posicionarUnidad(posicionNueva, this.turnoActual.obtenerUnidadReciente());
		
	}
}
