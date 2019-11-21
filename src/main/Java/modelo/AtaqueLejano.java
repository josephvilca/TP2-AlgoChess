package modelo;

public class AtaqueLejano extends Ataque {
	private int rangoMin ;

	public AtaqueLejano(){
		this.rangoMin= 6;
	}
	
	public void atacar(UnidadDeJuego atacante, UnidadDeJuego victima){
		
		int x = atacante.posicion.distanciaX(victima.posicion);
		int y = atacante.posicion.distanciaY(victima.posicion);
		if(x >= this.rangoMin || y >= this.rangoMin){
			atacante.atacarRange(victima);
		}	
	}
}
