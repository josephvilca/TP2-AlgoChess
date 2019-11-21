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
		if(this.turno % 2 == 0){  //jugador 2 
			
			this.unidadSeleccionada = this.tablero.obtenerUnidad(posicionSeleccionada);
			if(!this.unidadSeleccionada.perteneceA(jugador2))
				this.unidadSeleccionada = null;	
		}
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
	}
	
	public void atacar(int x, int y){
		Posicion pos = new Posicion(x, y);
		UnidadDeJuego victima = this.tablero.obtenerUnidad(pos);
		this.unidadSeleccionada.atacar(victima);
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

		if(this.turno % 2 == 0){  
			this.tienda.venderUnidad(jugador2, indice);
			this.tablero.posicionarUnidad(posicionNueva, this.jugador2.obtenerUnidadReciente());
		}
		else{
			this.tienda.venderUnidad(jugador1, indice);
			this.tablero.posicionarUnidad(posicionNueva, this.jugador1.obtenerUnidadReciente());
		}
	}
}
