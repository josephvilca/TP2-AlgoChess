package modelo;

public abstract class UnidadDeJuego {

	protected int vida, costo;
	public Posicion posicion;
	
	public void recibirDano(int damage){
		this.vida -= damage;
	}
	
	public void mover(Posicion nuevaPos){
		this.posicion = nuevaPos;
	}
	
	public abstract boolean puedoMoverme();
	
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
