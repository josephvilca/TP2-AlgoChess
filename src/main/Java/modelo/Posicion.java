package modelo;
import java.util.*;

public class Posicion{

	
	public int x;
	public int y;


	public Posicion(int x, int y){
		this.x = x;
		this.y = y;
		
	}

	// rango 1 o 2
	public List<UnidadDeJuego> unidadesCercanas(Tablero tablero){
		List<UnidadDeJuego> lista = new ArrayList<UnidadDeJuego>();

		lista = unidadesCercanasA1(tablero);
		
		//distancia 2
		
		for(int i=x-2; i <= x+2; i++){
			UnidadDeJuego unidad = tablero.obtenerUnidad(new Posicion(i, y-2));
			if(unidad != null) lista.add(unidad);
		}
		
		for(int i=y-1; i <= y+2; i++){
			UnidadDeJuego unidad = tablero.obtenerUnidad(new Posicion(x-2, i));
			if(unidad != null) lista.add(unidad);
		}
		for(int i=x-1; i <= x+2; i++){
			UnidadDeJuego unidad = tablero.obtenerUnidad(new Posicion(i, y+2));
			if(unidad != null) lista.add(unidad);
		}
		for(int i=y-1; i <= y+1; i++){
			UnidadDeJuego unidad = tablero.obtenerUnidad(new Posicion(x+2, i));
			if(unidad != null) lista.add(unidad);
		}
		return lista;
	}

	public List<UnidadDeJuego> unidadesCercanasA1(Tablero tablero){
		List<UnidadDeJuego> lista = new ArrayList<UnidadDeJuego>();

		for(int i=x-1; i <= x+1; i++){
			UnidadDeJuego unidad = tablero.obtenerUnidad(new Posicion(i, y+1));
			if(unidad != null) lista.add(unidad);
		}
		
		for(int i=x-1; i <= x+1; i++){
			UnidadDeJuego unidad = tablero.obtenerUnidad(new Posicion(i, y));
			if(unidad != null) lista.add(unidad);
		}
		for(int i=x-1; i <= x+1; i++){
			UnidadDeJuego unidad = tablero.obtenerUnidad(new Posicion(i, y-1));
			if(unidad != null) lista.add(unidad);
		}
		return lista;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Posicion otraPos = (Posicion) obj;
        //return this.igualPosicionA(otraPos);
		return (this.x == otraPos.x && this.y == otraPos.y);
		
	}


	@Override
	public int hashCode(){
		final int prime = 31;
	    int result = 1;
	    result = prime * result + x;
        result = prime * result + y;
        return result;	
	}


	public Posicion getPosicionArriba() {
		return new Posicion(this.x, this.y+1);
	}

	public Posicion getDiagonalArribaIzquierda(){
		return new Posicion(this.x-1, this.y+1);
	}
	
	public Posicion getPosicionAbajo() {
		return new Posicion(this.x, this.y+1);
	}

	public Posicion getDiagonalAbajoIzquierda(){
		return new Posicion(this.x-1, this.y+1);
	}

	public Posicion getDiagonalAbajoDerecha(){
		return new Posicion(this.x+1, this.y+1);
	}
	

	public Posicion getPosicionDerecha() {
		return new Posicion(this.x+1, this.y);
	}

	public Posicion getDiagonalArribaDerecha(){
		return new Posicion(this.x-1, this.y-1);
	}

	public Posicion getPosicionIzquierda() {
		return new Posicion(this.x-1, this.y);
	}
	
	public float distancia(Posicion pos){
		float xPart = (float)Math.pow(this.x - pos.x, 2);
		float yPart = (float)Math.pow(this.y - pos.y, 2);
		return (float)Math.sqrt(xPart+yPart) ;
	}

	public boolean aDistancia1(Posicion pos){
		return (distancia(pos) <= Math.sqrt(2));
	}

	public boolean aDistancia2(Posicion pos){
		return (distancia(pos) <= Math.sqrt(8));
	}

	
	public int distanciaX(Posicion pos){
		int res = pos.x - this.x;
		return Math.abs(res);
	}
	
	public int distanciaY(Posicion pos){
		int res = pos.y - this.y;
		return Math.abs(res);
	}
	
	public boolean estaEnLimmites(int limiteInfX, int limiteInfY ,int limiteSupX ,int limiteSupY) {
		
		boolean ok1 = (this.x >= limiteInfX && this.x < limiteSupX);
		boolean ok2 = (this.y >= limiteInfY && this.y < limiteSupY);
		
		return (ok1 && ok2);
	}


}