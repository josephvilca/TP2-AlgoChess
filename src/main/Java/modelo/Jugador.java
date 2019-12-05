package modelo;

import java.util.*;

public class Jugador {
	
	int monedas;
	String nombre;
	protected HashMap<Posicion, UnidadDeJuego> casillas;
	public UnidadesDeJugador unidadesJugador;
	
	public Jugador(int cantidadMonedas) {
		this.monedas = cantidadMonedas;		
		this.unidadesJugador = null;
	}

	public void setearTipoDeUnidades(UnidadesDeJugador tipo){
		this.unidadesJugador = tipo;
	}
	public boolean comprar(UnidadDeJuego unidad){
		if(this.monedas < unidad.costo()) return false;
		
		this.monedas -= unidad.costo();
		this.unidadesJugador.agregar(unidad);
		
		return true;
	}
	
	public int numeroDePiezas(){
		return unidadesJugador.tam();
	}
	
	public UnidadDeJuego obtenerUnidadReciente(){
		return unidadesJugador.obtenerUnidadReciente();
	}
	
	public void perderPieza(UnidadDeJuego pieza){
		unidadesJugador.perderPieza(pieza);
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return this.nombre;
				
	}
	
	public boolean derrotado(){
		return numeroDePiezas() == 0;
	}
	
	public UnidadesDeJugador unidades(){
		return unidadesJugador;
	}
	
	public int monedas(){
		return monedas;
	}
}
