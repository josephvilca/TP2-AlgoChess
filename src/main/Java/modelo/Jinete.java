package modelo;

public class Jinete extends UnidadDeJuego{

	private int meeleDamage, rangeDamage; 
	public Ataque ataque;
	
	public Jinete(){
		this.costo = 3;
		this.vida = 100;
		this.meeleDamage = 5;
		this.rangeDamage = 15;
		
	}

	public void accionar(Tablero tablero, Posicion pos){
		tablero.atacar(this, pos);
	}
	
	public void atacar(UnidadDeJuego victima){
		
		this.ataque.atacar(this, victima);
	}
	
	public void setearAtaque(Ataque tipoAtaque){
		this.ataque = tipoAtaque;
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

}
