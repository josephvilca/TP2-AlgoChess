package modelo;

public class UJugador2 extends UnidadesDeJugador{

	public UJugador2(){
		super();
	}
	
	@Override
	public boolean estoyEnMisector(Posicion pos) {
		return pos.estaEnLimmites(0, 0, 20, 10);
	}

}
