package modelo;

public class AtaqueCercano extends Ataque{
	private int rangoMax ;

	public AtaqueCercano(){
		this.rangoMax = 2;
	}
	
	public void atacar(UnidadDeJuego atacante, UnidadDeJuego victima){
		
		/*int x = atacante.posicion.distanciaX(victima.posicion);
		int y = atacante.posicion.distanciaY(victima.posicion);
		if(x <= this.rangoMax && y <= this.rangoMax){
			atacante.atacarMeele(victima);
		}*/
		if(atacante.posicion.aDistancia1(victima.posicion) || atacante.posicion.aDistancia2(victima.posicion))
			atacante.atacarMeele(victima);
	}
}
