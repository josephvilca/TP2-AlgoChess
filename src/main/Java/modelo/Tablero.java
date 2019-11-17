package modelo;
import java.util.*;

public class Tablero {

	protected HashMap<Posicion, UnidadDeJuego> casillas;

	public Tablero(){
		
		this.casillas = new HashMap<Posicion, UnidadDeJuego>();
		
	}

	public boolean posicionInvalida(Posicion unaPosicion){

		boolean filtro1 = this.casillas.containsKey(unaPosicion);
		boolean filtro2 = (!unaPosicion.estaEnLimmites(0, 0, 20,20));
		
		return (filtro1 || filtro2);
	}
	
	
	public void posicionarUnidad(Posicion posicionDeUnidad, UnidadDeJuego unidad){
		if(this.posicionInvalida(posicionDeUnidad)) return;
		this.casillas.put(posicionDeUnidad, unidad);
	}
	
	public UnidadDeJuego obtenerUnidad(Posicion posicion){
		return this.casillas.get(posicion);
	}
	
	private void moverUnidad(UnidadDeJuego unidad, Posicion desde, Posicion hasta){
		
		if(unidad.puedoMoverme() && !this.casillas.containsKey(hasta)){
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
		
	
	
	
}
