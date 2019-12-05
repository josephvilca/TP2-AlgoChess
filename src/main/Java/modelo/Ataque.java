package modelo;

public abstract class Ataque {

	public abstract void atacar(UnidadDeJuego atacante, UnidadDeJuego victima);
	public abstract void atacarBonus(UnidadDeJuego atacante, UnidadDeJuego victima, int bonus);
}
