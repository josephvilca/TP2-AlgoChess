package modelo;

import java.util.*;

public class Jugador {
	
	int monedas;
	String nombre;
	protected HashMap<Posicion, UnidadDeJuego> casillas;
	public List<UnidadDeJuego> unidades;
	
	public Jugador(int cantidadMonedas) {
		this.monedas = cantidadMonedas;
		this.unidades = new ArrayList<UnidadDeJuego>();
	}

	public boolean comprar(UnidadDeJuego unidad){
		if(this.monedas < unidad.costo()) return false;
		
		this.monedas -= unidad.costo();
		this.unidades.add(unidad);
		
		return true;
	}
	
	public int numeroDePiezas(){
		return this.unidades.size();
	}
	
	public UnidadDeJuego obtenerUnidadReciente(){
		return this.unidades.get(this.unidades.size()-1);
	}
	
	public void perderPieza(UnidadDeJuego pieza){
		this.unidades.remove(pieza);
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
}
