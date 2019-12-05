package modelo;

public class FaseInicial implements EstadoDeTurno{

	Juego juego;
	
	public FaseInicial(Juego juego){
		this.juego = juego;
	}
	
	@Override
	public void seleccionarDelTablero(int x, int y) {
		System.out.println("No se puede realizar esta accion en la fase inicial");
	}

	@Override
	public void posicionarUnidad(int x, int y) {
		System.out.println("No se puede realizar esta accion en la fase inicial");
	}

	@Override
	public void terminarTurno() {
		if(this.juego.turnoActual.numeroDePiezas() == 0 ){
			System.out.println("Al menos se necesita 1 unidad para terminar la fase inicial");
			return;
		}
		this.juego.turnoActual = this.juego.jugador2;
		this.juego.tablero.actualizarUnidadesDeJugadores(this.juego.jugador2.unidades(), this.juego.jugador1.unidades());
		this.juego.cambiarEstado(juego.faseInicial2);
		
	}

	@Override
	public void accionar(int x, int y) {
		System.out.println("No se puede realizar esta accion en la fase inicial");
	}

	@Override
	public void moverPiezaSeleccionada(int x, int y) {
		System.out.println("No se puede realizar esta accion en la fase inicial");	
	}

	@Override
	public void comprarUnidad(int indice, int x, int y) {
		Posicion posicionNueva = new Posicion(x,y);
		
		if(juego.tienda.venderUnidad(juego.turnoActual, indice))
			juego.tablero.posicionarUnidad(posicionNueva, juego.turnoActual.obtenerUnidadReciente());
		
		else juego.turnoActual.perderPieza(juego.turnoActual.obtenerUnidadReciente());;
		
	}

}
