package modelo;

public class AtaqueCercano extends Ataque{
	private int rangoMax ;

	public AtaqueCercano(){
		this.rangoMax = 2;
	}
	
	public void atacar(UnidadDeJuego atacante, UnidadDeJuego victima){
		
		
		if(atacante.posicion.aDistancia1(victima.posicion) || atacante.posicion.aDistancia2(victima.posicion)){
			atacante.atacarMeele(victima);
		}		
	}
	
	public void atacarBonus(UnidadDeJuego atacante, UnidadDeJuego victima, int bonus){
		
		
		if(atacante.posicion.aDistancia1(victima.posicion) || atacante.posicion.aDistancia2(victima.posicion)){
			int dmg = atacante.meeleDamage + (atacante.meeleDamage *bonus /10 );
			victima.recibirDano(dmg);
		}		
	}
}
