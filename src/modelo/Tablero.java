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
	

	public void moverUnidadAdelante(Posicion posicionDeUnidad){
		
		UnidadDeJuego unidad =  this.casillas.get(posicionDeUnidad);
		this.casillas.remove(posicionDeUnidad);
		this.casillas.put(unidad.arriba(), unidad);
		
	}
	
	public void moverUnidadAtras(Posicion posicionDeUnidad){
		
		UnidadDeJuego unidad =  this.casillas.get(posicionDeUnidad);
		this.casillas.remove(posicionDeUnidad);
		this.casillas.put(unidad.abajo(), unidad);
		
	}
	
	public void moverUnidadDerecha(Posicion posicionDeUnidad){
		UnidadDeJuego unidad =  this.casillas.get(posicionDeUnidad);
		this.casillas.remove(posicionDeUnidad);
		this.casillas.put(unidad.derecha(), unidad);
		
	}
	
	public void moverUnidadIzquierda(Posicion posicionDeUnidad){
		UnidadDeJuego unidad =  this.casillas.get(posicionDeUnidad);
		this.casillas.remove(posicionDeUnidad);
		this.casillas.put(unidad.izquierda(), unidad);
		
	}
		
	
	
	
}
