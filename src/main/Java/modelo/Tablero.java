package modelo;
import java.util.*;

import com.sun.javafx.collections.MapAdapterChange;

public class Tablero {

	protected HashMap<Posicion, UnidadDeJuego> casillas;
	protected UnidadesDeJugador unidadesJugadorActual; 
	protected UnidadesDeJugador unidadesEnemigas; 
	Movimientos mov;
	
	public Tablero(){
		this.mov = new Movimientos(this);
		this.casillas = new HashMap<Posicion, UnidadDeJuego>();
	}

	public boolean unidadAliada(UnidadDeJuego unidad){
		return this.unidadesJugadorActual.pertenece(unidad);
	}
	
	public boolean unidadEnemiga(UnidadDeJuego unidad){
		return this.unidadesEnemigas.pertenece(unidad);
	}
	
	
	public boolean posicionInvalida(Posicion unaPosicion){

		boolean filtro1 = this.casillas.containsKey(unaPosicion);
		boolean filtro2 = (!unaPosicion.estaEnLimmites(0, 0, 20,20));
		
		return (filtro1 || filtro2);
	}
	
	public boolean moverUnidad(Posicion posInicial, Posicion posFinal){
		UnidadDeJuego unidad =  this.casillas.get(posInicial);
		return mov.mover(posInicial, posFinal, unidad);
	}
	
	public void borrarUnidad(Posicion pos){
		this.casillas.remove(pos);
	}
	
	public void actualizarUnidadesDeJugadores(UnidadesDeJugador aliados, UnidadesDeJugador enemigos){
		this.unidadesJugadorActual = aliados;
		this.unidadesEnemigas = enemigos;
	}
	
	public boolean posicionarUnidad(Posicion posicionDeUnidad, UnidadDeJuego unidad){
		if(this.posicionInvalida(posicionDeUnidad) || !unidadesJugadorActual.estoyEnMisector(posicionDeUnidad)) return false;
		unidad.mover(posicionDeUnidad);
		this.casillas.put(posicionDeUnidad, unidad);
		return true;
	}
	
	public boolean avanzarUnidad(Posicion posicionDeUnidad, UnidadDeJuego unidad){
		if(this.posicionInvalida(posicionDeUnidad)) return false;
		unidad.mover(posicionDeUnidad);
		this.casillas.put(posicionDeUnidad, unidad);
		return true;
	}
	
	
	public UnidadDeJuego obtenerUnidad(Posicion posicion){
		return this.casillas.get(posicion);
	}
	
	
	public void atacar(Jinete atacante, Posicion posVictima){
		
		
		UnidadDeJuego victima = this.obtenerUnidad(posVictima);
		List<UnidadDeJuego> unidadesCerca = atacante.posicion.unidadesCercanas(this);
		System.out.println(unidadesCerca.size());
		
		boolean ataqueMediano= false;
		boolean enemigosCerca = false;
		for(UnidadDeJuego u : unidadesCerca){
			if(u instanceof SoldadoInfanteria && this.unidadesJugadorActual.pertenece(u)) ataqueMediano= true;
			;
			if(this.unidadesEnemigas.pertenece(u)) enemigosCerca= true;
			
		}
		if(ataqueMediano || !enemigosCerca) {
			atacante.setearAtaque(new AtaqueMediano());
			atacante.atacar(victima);
			return;
		}


		if(enemigosCerca ) atacante.setearAtaque(new AtaqueCercano());
		atacante.atacar(victima);
		if(victima.estaDestruido())
			this.unidadesEnemigas.perderPieza(victima);
		
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
		if(this.unidadAliada(aliado))
			atacante.curar(aliado);
		
	}

	public HashMap<Posicion, UnidadDeJuego> casillas(){
		return casillas;
	}
}
