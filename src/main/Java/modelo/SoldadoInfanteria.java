package modelo;

public class SoldadoInfanteria extends UnidadDeJuego {

	private int meeleDamage, rangeDamage; 
	private Ataque ataque;
	
	public SoldadoInfanteria(Jugador dueno){
		super(dueno);
		this.costo = 1;
		this.vida = 100;
		this.meeleDamage = 10;
		this.rangeDamage = 0;
		this.ataque = new AtaqueCercano();
	}
	
	public boolean puedoMoverme(){
		return true;
	}
	

	public void atacarMeele(UnidadDeJuego victima){
		victima.recibirDano(this.meeleDamage);
	}

	public void atacarRange(UnidadDeJuego victima){
		victima.recibirDano(this.rangeDamage);
	}

	public void atacar(UnidadDeJuego victima){

		this.ataque.atacar(this, victima);
	}
	
}
