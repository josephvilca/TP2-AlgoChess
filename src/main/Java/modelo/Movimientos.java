package modelo;

import java.util.ArrayList;
import java.util.List;

public class Movimientos {

	Tablero tablero;
	
	public Movimientos(Tablero tablero){
		this.tablero  = tablero;
	}
	
	public boolean mover(Posicion posIni, Posicion posDestino, UnidadDeJuego unidad){
		if(posIni.aDistancia1(posDestino) && unidad.puedoMoverme() && tablero.unidadAliada(unidad) ){
			
			if(unidad instanceof SoldadoInfanteria){
				this.moverComoBatallon(unidad, posIni, posDestino);
				System.out.println("Moviendo como soldado de infanteria");
			}
			
			if(this.tablero.avanzarUnidad(posDestino, unidad)){
				this.tablero.borrarUnidad(posIni);
				return true;
			}
		}
		return false;
	}
	
	
	private void moverComoBatallon(UnidadDeJuego unidad, Posicion pos1, Posicion pos2){
		int cont = 0, primeros = 2;
		
		List<UnidadDeJuego> unidadesCerca = unidad.posicion.unidadesCercanasA1(tablero);
		List<UnidadDeJuego> soldadosAliados = new ArrayList<UnidadDeJuego>();
		
		unidadesCerca.remove(unidad);
		for(UnidadDeJuego u: unidadesCerca){
			if(u instanceof SoldadoInfanteria && tablero.unidadAliada(u)) {
				soldadosAliados.add(u);
				cont++;			
			}
		}
		
		
		if(soldadosAliados.size() >= 2){
			while(soldadosAliados.size() != 2){
				soldadosAliados.remove(soldadosAliados.size()-1);
			}
			/*
			for(UnidadDeJuego u: soldadosAliados){
				tablero.borrarUnidad(u.getPosicion());			
			}
			*/
			for(UnidadDeJuego u: soldadosAliados){
				identificarMov(pos1, pos2, u);
				
			}
			
		
		}
	}
	
	private void identificarMov(Posicion pos1, Posicion pos2, UnidadDeJuego unidad){
		if(pos2.equals(pos1.getDiagonalAbajoDerecha())){
			Posicion pos = unidad.getPosicion();
			if(tablero.avanzarUnidad(pos.getDiagonalAbajoDerecha(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getDiagonalAbajoIzquierda())){
			Posicion pos = unidad.getPosicion();
			if(tablero.avanzarUnidad(pos.getDiagonalAbajoIzquierda(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getDiagonalArribaDerecha())){
			Posicion pos = unidad.getPosicion();
			if(tablero.avanzarUnidad(pos.getDiagonalArribaDerecha(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getDiagonalArribaIzquierda())){
			Posicion pos = unidad.getPosicion();
			if(tablero.avanzarUnidad(pos.getDiagonalArribaIzquierda(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getPosicionArriba())){
			Posicion pos = unidad.getPosicion();
			if(tablero.avanzarUnidad(pos.getPosicionArriba(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getPosicionAbajo())){
			Posicion pos = unidad.getPosicion();
			if(tablero.avanzarUnidad(pos.getPosicionAbajo(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getPosicionIzquierda())){
			Posicion pos = unidad.getPosicion();
			if(tablero.avanzarUnidad(pos.getPosicionIzquierda(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getPosicionDerecha())){
			Posicion pos = unidad.getPosicion();
			if(tablero.avanzarUnidad(pos.getPosicionDerecha(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		
	}
	
	
	
}
