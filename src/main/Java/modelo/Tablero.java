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
		unidad.mover(posicionDeUnidad);
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
			if(u.posicion.aDistancia1(desde) && this.unidadesJugadorActual.contains(u)){
				if(!this.casillas.containsKey(hasta)){
					this.casillas.remove(u);
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
		
		System.out.println("CABALLO A PUNTO DE ATACAR");
		
		UnidadDeJuego victima = this.obtenerUnidad(posVictima);
		List<UnidadDeJuego> unidadesCerca = atacante.posicion.unidadesCercanas(this);
		System.out.println(unidadesCerca.size());
		
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
		if(victima.estaDestruido())
			this.unidadesEnemigas.remove(victima);
		
	}


	public void atacar(UnidadDeJuego atacante, Posicion posVictima){
		
		UnidadDeJuego victima = this.obtenerUnidad(posVictima);

		atacante.atacar(victima);
		
	}
	
	public void accionar(UnidadDeJuego atacante, Posicion posObjetivo){
		
		//UnidadDeJuego objetivo = this.obtenerUnidad(posObjetivo);
		atacante.accionar(this, posObjetivo);
		
		
	}

	public void curar(UnidadDeJuego atacante, Posicion posAliado){
		
		UnidadDeJuego aliado = this.obtenerUnidad(posAliado);
		atacante.curar(aliado);

		
	}
		
}
