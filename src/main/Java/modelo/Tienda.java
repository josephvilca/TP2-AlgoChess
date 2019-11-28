package modelo;

public class Tienda {
	
	public boolean venderUnidad(Jugador jugador, int indiceItem){
		
		switch (indiceItem){
			
			case 0: return jugador.comprar(new SoldadoInfanteria());
					
			case 1: return jugador.comprar(new Jinete());
			
			case 2: return jugador.comprar(new Curandero());
			
			case 3: return jugador.comprar(new Catapulta());
						
		}
		return false;
		
	}
	
}
