package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class UnidadesDeJugador {
	public List<UnidadDeJuego> unidades;
	
	public UnidadesDeJugador(){
		this.unidades = new ArrayList<UnidadDeJuego>();
	}
	
	public abstract boolean estoyEnMisector(Posicion pos);

	public void agregar(UnidadDeJuego unidad) {
		unidades.add(unidad);
	}
	
	public int tam(){
		return unidades.size();
	}
	
	public UnidadDeJuego obtenerUnidadReciente(){
		return unidades.get(unidades.size()-1);	
	}
	
	public void perderPieza(UnidadDeJuego pieza){
		unidades.remove(pieza);		
	}
	
	public List<UnidadDeJuego> unidades(){
		return unidades;
	}
	
	public boolean pertenece(UnidadDeJuego unidad){
		return unidades.contains(unidad);
	}
}
