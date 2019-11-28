package modelo;

public class Curandero extends UnidadDeJuego{
	
	private int curacion = 15;
	
	public Curandero(){
		this.costo = 2;
		this.vida = 75;
	}
	
	public boolean puedoMoverme(){
		return true;
	}
	
	public void accionar(Tablero tablero, Posicion pos){
		tablero.curar(this, pos);
	}
	
	public void curar(UnidadDeJuego unidad){
		unidad.recibirDano(curacion*-1);
	}
	
	public void atacar(UnidadDeJuego victima){
	}
	
	public void atacarMeele(UnidadDeJuego victima){
	;
	}

	public void atacarRange(UnidadDeJuego victima){
	;
	}

}
