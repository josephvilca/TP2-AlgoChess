package modelo;

public abstract class UnidadDeJuego {

	protected int vida, costo;
	public Posicion posicion;
	
	public abstract void recibirDano();
	
	public Posicion derecha(){
		return posicion.getPosicionDerecha();
	}
	
	public Posicion izquierda(){
		return posicion.getPosicionIzquierda();
	}
	
	public Posicion abajo(){
		return posicion.getPosicionAbajo();
	}
	
	public Posicion arriba(){
		return posicion.getPosicionArriba();
	}
	
	
	
}
