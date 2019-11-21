package modelo;

public class AtaqueMediano extends Ataque{
	
	private int rangoMin, rangoMax;

	public AtaqueMediano(){
		this.rangoMin = 3;
		this.rangoMax = 5;
	}
	public void atacar(UnidadDeJuego atacante, UnidadDeJuego victima){
		
		int x = atacante.posicion.distanciaX(victima.posicion);
		int y = atacante.posicion.distanciaY(victima.posicion);
		boolean filtro1 = (x >= this.rangoMin || y >= this.rangoMin );  
		boolean filtro2 = (x <= this.rangoMax && y <= this.rangoMax);
				
		if(filtro1 && filtro2){
			atacante.atacarRange(victima);
		}	
	}

}
