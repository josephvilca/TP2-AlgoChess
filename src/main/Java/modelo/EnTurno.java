package modelo;

public class EnTurno implements EstadoDeTurno{

	Juego juego;
	
	public EnTurno(Juego juego){
		this.juego = juego;
	}
	
	@Override
	public void seleccionarDelTablero(int x, int y) {
		Posicion posicionSeleccionada = new Posicion(x,y);
		this.juego.unidadSeleccionada = juego.tablero.obtenerUnidad(posicionSeleccionada);
		if(juego.unidadSeleccionada != null){
			juego.cambiarEstado(juego.estadoSeleccionado);
		}
	}

	@Override
	public void posicionarUnidad(int x, int y) {
		System.out.println("solo se posicionan unidades al principio");
		
	}

	@Override
	public void terminarTurno() {

		juego.terminarTurno();
	}

	@Override
	public void accionar(int x, int y) {
		System.out.println("Se necesita primero seleccionar una unidad");
	}

	@Override
	public void moverPiezaSeleccionada(int x, int y) {
		System.out.println("Se necesita primero seleccionar una unidad");
	}

	@Override
	public void comprarUnidad(int indice, int x, int y) {
		System.out.println("No se puede comprar unidades fuera de la fase inicial");
	}

}
