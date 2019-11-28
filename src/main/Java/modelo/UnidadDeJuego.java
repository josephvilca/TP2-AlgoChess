package modelo;

public abstract class UnidadDeJuego {

	protected int vida, costo;
	public Posicion posicion;
	public Jugador dueno;
	

	
	public void recibirDano(int damage){
		this.vida -= damage;
		if(this.vida <= 0) {
			this.dueno.perderPieza(this);
		}
	}
	
	public boolean estaDestruido(){
		return this.vida <= 0;
	}
	
	public void curar(UnidadDeJuego unidad){
		System.out.println("implementar");
	}
	
	public abstract void atacar(UnidadDeJuego victima);
	
	public abstract void atacarMeele(UnidadDeJuego victima);

	public abstract void atacarRange(UnidadDeJuego victima);
	
	public void mover(Posicion nuevaPos){
		this.posicion = nuevaPos;
	}

	public int vida() {
		return this.vida;
	}
	
	public int costo(){
		return this.costo;
	}
	
	/*public void actualizarPosicion(Posicion nuevaPos){
		this.posicion = nuevaPos;
	}*/
	
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
