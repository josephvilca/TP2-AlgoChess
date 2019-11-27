package modelo;
import java.util.*;

public class Tablero {

	protected HashMap<Posicion, UnidadDeJuego> casillas;
	private List<UnidadDeJuego> unidadesJugadorActual; 
	private List<UnidadDeJuego> unidadesEnemigas; 
	
	
	public Tablero(){
		
		this.casillas = new HashMap<Posicion, UnidadDeJuego>();
		
	}

	public boolean posicionInvalida(Posicion unaPosicion){

		boolean filtro1 = this.casillas.containsKey(unaPosicion);
		boolean filtro2 = (!unaPosicion.estaEnLimmites(0, 0, 20,20));
		
		return (filtro1 || filtro2);
	}
	
	public void actualizarUnidadesDeJugadores(List<UnidadDeJuego> aliados, List<UnidadDeJuego> enemigos){
		this.unidadesJugadorActual = aliados;
		this.unidadesEnemigas = enemigos;
	}
	
	public void posicionarUnidad(Posicion posicionDeUnidad, UnidadDeJuego unidad){
		if(this.posicionInvalida(posicionDeUnidad)) return;
		this.casillas.put(posicionDeUnidad, unidad);
	}
	
	public UnidadDeJuego obtenerUnidad(Posicion posicion){
		return this.casillas.get(posicion);
	}
	
	private void moverUnidad(UnidadDeJuego unidad, Posicion desde, Posicion hasta){
		
		if(unidad.puedoMoverme() && !this.casillas.containsKey(hasta) && this.unidadesJugadorActual.contains(unidad)){
			this.casillas.remove(desde);
			this.casillas.put(hasta, unidad);
			unidad.mover(hasta);
			
		}
	}	
	
	private void moverUnidad(SoldadoInfanteria unidad, Posicion desde, Posicion hasta){
		
		List<UnidadDeJuego> unidadesCerca = unidad.posicion.unidadesCercanas(this);
		
		for(UnidadDeJuego u : unidadesCerca){
			if(u.posicion.distancia(desde) <= Math.sqrt(2) && this.unidadesJugadorActual.contains(u)){
				if(!this.casillas.containsKey(hasta)){
					this.casillas.remove(desde);
					this.casillas.put(hasta, unidad);
					unidad.mover(hasta);
				
				}
				
			}
				
		}

		if(!this.casillas.containsKey(hasta) && this.unidadesJugadorActual.contains(unidad)){
			this.casillas.remove(desde);
			this.casillas.put(hasta, unidad);
			unidad.mover(hasta);
			
		}
	}	
	
	public void moverUnidadAdelante(Posicion posicionDeUnidad){
		
		UnidadDeJuego unidad =  this.casillas.get(posicionDeUnidad);
		this.moverUnidad(unidad, posicionDeUnidad, posicionDeUnidad.getPosicionArriba());
		
	}
	
	public void moverUnidadAtras(Posicion posicionDeUnidad){
		
		UnidadDeJuego unidad =  this.casillas.get(posicionDeUnidad);
		this.moverUnidad(unidad, posicionDeUnidad, posicionDeUnidad.getPosicionAbajo());
	}
	
	public void moverUnidadDerecha(Posicion posicionDeUnidad){
		
		UnidadDeJuego unidad =  this.casillas.get(posicionDeUnidad);
		this.moverUnidad(unidad, posicionDeUnidad, posicionDeUnidad.getPosicionDerecha());
	}
	
	public void moverUnidadIzquierda(Posicion posicionDeUnidad){

		UnidadDeJuego unidad =  this.casillas.get(posicionDeUnidad);
		this.moverUnidad(unidad, posicionDeUnidad, posicionDeUnidad.getPosicionIzquierda());
	}

	public void atacar(Jinete atacante, Posicion posVictima){
		
		UnidadDeJuego victima = this.obtenerUnidad(posVictima);
		List<UnidadDeJuego> unidadesCerca = atacante.posicion.unidadesCercanas(this);
		boolean ataqueMediano= false;
		boolean enemigosCerca = false;
		for(UnidadDeJuego u : unidadesCerca){
			if(u instanceof SoldadoInfanteria && this.unidadesJugadorActual.contains(u)) ataqueMediano= true;
			;
			if(this.unidadesEnemigas.contains(u)) enemigosCerca= true;
			
		}
		if(ataqueMediano || !enemigosCerca) {
			atacante.setearAtaque(new AtaqueMediano());
			atacante.atacar(victima);
			return;
		}
		
		for(UnidadDeJuego u : unidadesCerca){
			if(this.unidadesJugadorActual.contains(u)) ataqueMediano= true;
		}
		
		if(enemigosCerca && !ataqueMediano) atacante.setearAtaque(new AtaqueCercano());
		atacante.atacar(victima);
		
	}
	public void atacar(UnidadDeJuego atacante, Posicion posVictima){
		
		UnidadDeJuego victima = this.obtenerUnidad(posVictima);

		atacante.atacar(victima);
		
	}
	//public atacar()
	
	
	
}
