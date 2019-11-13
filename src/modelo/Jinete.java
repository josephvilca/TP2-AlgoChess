package modelo;

public class Jinete extends UnidadDeJuego{

	private int meeleDamage, rangeDamage; 
	
	public Jinete(){
		
		this.costo = 3;
		this.vida = 100;
		this.meeleDamage = 5;
		this.rangeDamage = 15;
		
	}

	public boolean puedoMoverme(){
		return true;
	}
	
}
