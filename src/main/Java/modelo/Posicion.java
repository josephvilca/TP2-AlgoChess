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

		UnidadDeJuego unidad = tablero.obtenerUnidad(this.getPosicionAbajo());
		if(unidad != null)
			lista.add(unidad);
		unidad = tablero.obtenerUnidad(this.getPosicionArriba());
		
		if(unidad != null)
			lista.add(unidad);
		
		unidad = tablero.obtenerUnidad(this.getPosicionDerecha());
		
		if(unidad != null)
			lista.add(unidad);

		unidad = tablero.obtenerUnidad(this.getPosicionIzquierda());
		
		if(unidad != null)
			lista.add(unidad);
		
		//distancia 2
		unidad = tablero.obtenerUnidad(new Posicion(x+2, y));
		if(unidad != null)
			lista.add(unidad);

		unidad = tablero.obtenerUnidad(new Posicion(x-2, y));
		if(unidad != null)
			lista.add(unidad);

		unidad = tablero.obtenerUnidad(new Posicion(x, y-2));
		if(unidad != null)
			lista.add(unidad);

		unidad = tablero.obtenerUnidad(new Posicion(x-2, y+2));
		if(unidad != null)
			lista.add(unidad);

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


	public Posicion getPosicionAbajo() {
		return new Posicion(this.x, this.y-1);
	}


	public Posicion getPosicionDerecha() {
		return new Posicion(this.x+1, this.y);
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