package modelo;

public class UJugador1 extends UnidadesDeJugador {

	public UJugador1(){
		super();
	}
	
	@Override
	public boolean estoyEnMisector(Posicion pos) {
		return pos.estaEnLimmites(0, 10, 20, 20);
	}

}
