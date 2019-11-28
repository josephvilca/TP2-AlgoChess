package modelo;

import java.util.List;

public class Movimientos {

	Tablero tablero;
	
	public Movimientos(Tablero tablero){
		this.tablero  = tablero;
	}
	
	public void mover(Posicion posIni, Posicion posDestino, UnidadDeJuego unidad){
		if(posIni.aDistancia1(posDestino) && unidad.puedoMoverme() && tablero.unidadAliada(unidad) ){
			
			if(unidad instanceof SoldadoInfanteria){
				this.moverComoBatallon(unidad, posIni, posDestino);

			}
			
			if(this.tablero.posicionarUnidad(posDestino, unidad)){
				this.tablero.borrarUnidad(posIni);
			}
		}
	}
	
	private void moverComoBatallon(UnidadDeJuego unidad, Posicion pos1, Posicion pos2){
		int cont = 0, primeros = 2;

		List<UnidadDeJuego> unidadesCerca = unidad.posicion.unidadesCercanasA1(tablero);
		unidadesCerca.remove(unidad);
		for(UnidadDeJuego u: unidadesCerca){
			if(u instanceof SoldadoInfanteria && tablero.unidadAliada(u)) cont++;			
		}
	
		if(cont >= 2){
			for(UnidadDeJuego u: unidadesCerca){
				if(u instanceof SoldadoInfanteria && tablero.unidadAliada(u) && primeros >0){
					identificarMov(pos1, pos2, u);
					primeros--;
				}
			}
		
		}
	}
	
	private void identificarMov(Posicion pos1, Posicion pos2, UnidadDeJuego unidad){
		if(pos2.equals(pos1.getDiagonalAbajoDerecha())){
			Posicion pos = unidad.getPosicion();
			if(tablero.posicionarUnidad(pos.getDiagonalAbajoDerecha(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getDiagonalAbajoIzquierda())){
			Posicion pos = unidad.getPosicion();
			if(tablero.posicionarUnidad(pos.getDiagonalAbajoIzquierda(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getDiagonalArribaDerecha())){
			Posicion pos = unidad.getPosicion();
			if(tablero.posicionarUnidad(pos.getDiagonalArribaDerecha(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getDiagonalArribaIzquierda())){
			Posicion pos = unidad.getPosicion();
			if(tablero.posicionarUnidad(pos.getDiagonalArribaIzquierda(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getPosicionArriba())){
			Posicion pos = unidad.getPosicion();
			if(tablero.posicionarUnidad(pos.getPosicionArriba(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getPosicionAbajo())){
			Posicion pos = unidad.getPosicion();
			if(tablero.posicionarUnidad(pos.getPosicionAbajo(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getPosicionIzquierda())){
			Posicion pos = unidad.getPosicion();
			if(tablero.posicionarUnidad(pos.getPosicionIzquierda(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		if(pos2.equals(pos1.getPosicionDerecha())){
			Posicion pos = unidad.getPosicion();
			if(tablero.posicionarUnidad(pos.getPosicionDerecha(), unidad )){
				tablero.borrarUnidad(pos);
			}
		}
		
		
	}
	
	
	
}
