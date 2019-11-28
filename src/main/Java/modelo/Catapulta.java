package modelo;

public class Catapulta extends UnidadDeJuego{ 
	
	private int meeleDamage, rangeDamage;
	private Ataque ataque;
	
	public Catapulta(){
		this.costo = 5;
		this.vida = 50;
		this.meeleDamage = 0;
		this.rangeDamage = 20;
		this.ataque = new AtaqueLejano();
	}
	//solo distancia lejana
	public void atacar(UnidadDeJuego victima){
		this.ataque.atacar(this, victima);
	}
	
	public void mover(){
		
	}
	public boolean puedoMoverme(){
		return false;
	}
	
	public void atacarMeele(UnidadDeJuego victima){
		victima.recibirDano(this.meeleDamage);
	}

	public void atacarRange(UnidadDeJuego victima){
		victima.recibirDano(this.rangeDamage);
	}

	
}
