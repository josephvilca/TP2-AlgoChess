package modelo;

public class Curandero extends UnidadDeJuego{
	
	private int curacion = 15;
	
	public Curandero(Jugador dueno){
		super(dueno);
		this.costo = 2;
		this.vida = 75;
	}
	
	public boolean puedoMoverme(){
		return true;
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
