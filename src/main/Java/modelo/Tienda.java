package modelo;

public class Tienda {
	
	public boolean venderUnidad(Jugador jugador, int indiceItem){
		
		switch (indiceItem){
			
			case 0: return jugador.comprar(new SoldadoInfanteria(jugador));
					
			case 1: return jugador.comprar(new Jinete(jugador));
			
			case 2: return jugador.comprar(new Curandero(jugador));
			
			case 3: return jugador.comprar(new Catapulta(jugador));
						
		}
		return false;
		
	}
	
}
